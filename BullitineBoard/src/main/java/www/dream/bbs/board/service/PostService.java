package www.dream.bbs.board.service;

/**
 * @Service : 업무 처리
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.ReplyVO;
import www.dream.bbs.common.exception.BusinessException;
import www.dream.bbs.common.exception.ErrorCode;
import www.dream.bbs.framework.model.DreamPair;
import www.dream.bbs.framework.model.PagingDTO;
import www.dream.bbs.framework.nlp.pos.service.NounExtractor;
import www.dream.bbs.framework.property.PropertyExtractor;
import www.dream.bbs.iis.model.TagRelId;
import www.dream.bbs.iis.model.TagRelVO;
import www.dream.bbs.iis.model.TagVO;
import www.dream.bbs.iis.repository.TagRelRepository;
import www.dream.bbs.iis.repository.TagRepository;
import www.dream.bbs.party.model.PartyVO;

@Service
public class PostService {
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private TagRelRepository tagRelRepository;

	/** 게시판의 모든 원글 목록 조회 */
	public DreamPair<List<PostVO>, PagingDTO> listAllPost(String boardId, int page) {
		PagingDTO paging = new PagingDTO(page);
		List<PostVO> listResult = postMapper.listAllPost(boardId, paging);
		long dataCount = postMapper.getFoundRows();
		paging.buildPagination(dataCount);

		return new DreamPair(listResult, paging);
	}

	public DreamPair<List<PostVO>, PagingDTO> search(String boardId, String search, int page) {
		String[] arrSearch = search.split(" ");
		if (arrSearch.length == 0) {
			PagingDTO paging = new PagingDTO(page);
			paging.buildPagination(0);
			return new DreamPair(new ArrayList<>(), paging);
		}
		PagingDTO paging = new PagingDTO(page);
		List<PostVO> listResult = postMapper.searchByTfidf(boardId, arrSearch, paging);
		long dataCount = postMapper.getFoundRows();
		paging.buildPagination(dataCount);

		return new DreamPair(listResult, paging);
	}

	/** 원글 상세. {첨부파일 목록}, 댓글 목록이 내부 변수에 채워짐 */
	public PostVO findById(String id) {
		// postMapper.findById(id)는 id의 primary key 특성으로 사전순서가 보장되어 있음
		List<ReplyVO> oneDimList = postMapper.findById(id);
		if (oneDimList.isEmpty()) {
			return null;
		}

		PostVO ret = (PostVO) oneDimList.get(0);
		ret.incReadCnt();
		postMapper.incReadCnt(ret.getId());

		Map<String, ReplyVO> map = new HashMap<>();
		for (ReplyVO reply : oneDimList) {
			map.put(reply.getId(), reply);

			ReplyVO parent = map.get(reply.extractParentId());
			if (parent != null) {
				parent.appendReply(reply);
			}
		}
		return ret;
	}

	/* affected row counts */
	/**
	 * 게시판에 원글 달기 신규 tag면 등록 모든 tag와 TF 등재 및 tag의 df 수정
	 */
	@Transactional
	public int mngPost(PostVO post, PartyVO user) throws BusinessException {
		// post.id 있으면 수정, 없으면 신규,
		if (ObjectUtils.isEmpty(post.getId())) {
			post.setWriter(user);
			//  해당 게시판의 게시판 건수(post_cnt) 보면 올려줄래? 대시보드 
			int cnt = postMapper.createPost(post);
			return cnt;
		} else {
			// 수정 시는 post.writer.id == Principal user.id 이어야 함을 감시하여
			// 다르면 businessException을 발생 시켜야
			if (!post.getWriter().getId().equals(user.getId()))
				throw new BusinessException(ErrorCode.INVAID_UPDATE);
			int cnt = updatePost(post);
			return cnt;
		}
	}

	/*
	 * list.addAll(listNewTags.stream().map(TagVo->
	 * new TagVO
	 */
	/** 댓글 달기. parent의 hid의 연결된 hid 만들기 */
	public int createReply(ReplyVO parent, ReplyVO reply) {
		return postMapper.createReply(parent, reply);
	}

	/** tf, df 정보 수정도 고려하여야 함. */
	public int updatePost(PostVO post) {
		// 게시물과 단어 사이에 기존 관계 삭제
		tagRelRepository.deleteAllByPostId(post.getId());
		int cnt = postMapper.updatePost(post);
		createTagRelation(post);
		return cnt;
	}

	/** */
	public int updateReply(ReplyVO reply) {
		return postMapper.updateReply(reply);
	}

	/**
	 * hid like로 지우기 tf, df 정보 수정도 고려하여야 함.
	 */
	public int deleteReply(String id) {
		return postMapper.deleteReply(id);
	}

	/**
	 * // listTag에 담긴 단어에 대한 처리는.. // 기존 단어와 새로운 단어로 구분. // TF - IDF // 우리집에는 강아지
	 * 네오가 있습니다. 네오는 밝은 성격이고..... // 네오 : 2 // 우리집 : 1 // 강아지 : 1 // 성격 : 1
	 * 
	 */
	private Map<String, Integer> buildTF(PostVO post) {
		// 대상이 되는 문자열 추출
		List<String> docs = PropertyExtractor.extractProperty(post);

		List<String> listNoun = new ArrayList<>();
		for (String doc : docs) {
			if (doc == null)
				continue;
			// 대상이 되는 문자열 속 명사 추출
			doc = doc.trim();
			if (!doc.isEmpty())
				listNoun.addAll(NounExtractor.extracteNoun(doc));
		}

		// 게시글 수정 시 처리는 미루어 둘 것임
		Map<String, Integer> mapWordCnt = new HashMap<>();

		for (String noun : listNoun) {
			if (mapWordCnt.containsKey(noun)) {
				mapWordCnt.put(noun, mapWordCnt.get(noun) + 1);
			} else {
				mapWordCnt.put(noun, 1);
			}
		}
		return mapWordCnt;
	}
	
	private void createTagRelation(PostVO post) {
		Map<String, Integer> mapTF = buildTF(post);

		// 기존 단어 찾음. 기존 단어와 DF는 이 문서에서 나온 단어 출현 횟수를 올려주어야 함.
		List<TagVO> listExistingTags = tagRepository.findByWord(mapTF.keySet());

		// 세 단어 목록 찾기. 성능을 고려한 개발입니다. 따라서 정렬을 도입함.
		SortedSet<String> 기존단어목록 = new TreeSet(listExistingTags.stream().map(tagVo -> tagVo.getWord()).collect(Collectors.toList()));
		List<String> listNewWords = mapTF.keySet().stream().filter(word -> !기존단어목록.contains(word)).collect(Collectors.toList());
		List<TagVO> listNewTags = listNewWords.stream().map(newWord -> 
			new TagVO(tagRepository.getId("s_tag"), newWord, "")).collect(Collectors.toList());
		tagRepository.saveAll(listNewTags);

		// 게시물과 단어 사이에 관계 만들기
		List<TagRelVO> list = listExistingTags.stream().map(
				tagVo -> new TagRelVO(new TagRelId("T_reply", post.getId(), tagVo.getId()), mapTF.get(tagVo.getWord())))
				.collect(Collectors.toList());
		for (TagVO tagVo : listNewTags) {
			TagRelId id = new TagRelId("T_reply", post.getId(), tagVo.getId());
			list.add(new TagRelVO(id, mapTF.get(tagVo.getWord())));
		}
		tagRelRepository.saveAll(list);
	}

}