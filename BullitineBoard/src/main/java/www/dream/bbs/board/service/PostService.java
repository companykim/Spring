package www.dream.bbs.board.service;
/**
 * @Service : 업무 처리
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.dream.bbs.board.framework.nlp.pos.service.NounExtractor;
import www.dream.bbs.board.framework.property.PropertyExtractor;
import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.RipplyVO;

@Service   // Container에 담기도록 지정
public class PostService {
	@Autowired
	private PostMapper postMapper;
	
	/** 게시판의 모든 원글 조회*/
	public List<PostVO> listAllPost(String boardId) {
		List<PostVO> listResult = postMapper.listAllPost(boardId);
		return listResult;
	}
	
	/** 원글 상세, {첨부파일 목록}, 댓글 목록이 내부 변수에 채워짐 */
	public PostVO findById(String id) {
		// postMapper.findById(id)는 id의 primary key 특성으로 사전순서가 보장되어 있음.
		List<RipplyVO> oneDimList = postMapper.findById(id);
		if (oneDimList.isEmpty()) {
			
		}
		
		PostVO ret = (PostVO) oneDimList.get(0);
		Map<String, RipplyVO> map = new HashMap<>();
		for (RipplyVO reply : oneDimList) {
			map.put(reply.getId(), reply);
			
			RipplyVO parent = map.get(reply.extractParentId());
			if (parent != null) {
				parent.appendReply(reply);
			}
		}
		return ret;
	}
	
	/* affected row counts */
	/** 게시판에 원글 달기 
	 * 신규 tag면 등록
	 * 모든 tag와 TF(tag frequency) 등재 및 tag의 df(document frequency) 수정
	 */
	@Transactional
	public int createPost(PostVO post) {
		Map<String, Integer> mapTF = buildTF(post);
		
		return postMapper.createPost(post);
	}

	/** 댓글 달기, parent의 hid의 연결된 hid 만들기 */
	public int createRipply(RipplyVO parent, RipplyVO reply) {
		return postMapper.createRipply(parent, reply);
	}
	
	/** tf, df 정보 수정도 고려하여야 함. */
	public int updatePost(PostVO post) {
		return postMapper.updatePost(post);
	}
	
	/** */
	public int updateRipply(RipplyVO reply) {
		return postMapper.updateRipply(reply);
	}
	
	/** hid like로 지우기 
	 * tf, df 정보 수정도 고려하여야 함.
	 */
	public int deleteRipply(String id) {
		return postMapper.deleteRipply(id);
	}
	
	/**
	 *  // listTag에 담긴 단어에 대한 처리는...
		// 기존 간어와 새로운 단어로 구분.
		// TF - IDF
		// 우리집에는 강아지 네오가 있습니다. 네오는 밝은 성격이고...
		// 네오 : 2
		// 우리집 : 1
		// 강아지 : 1
		// 성격 : 1

	 */
	private Map<String, Integer> buildTF(PostVO post) {
		List<String> listData = new ArrayList<>();
		List<String> docs = PropertyExtractor.extractProperty(post);
		
		List<String> listNoun = new ArrayList<>();
		for (String doc : docs) {
			listNoun.addAll(NounExtractor.extracteNoun(doc));
		}
		
		List<String> listTag = post.getListTag();
		Map<String, Integer> mapWordCnt = new HashMap<>();
		listTag.forEach(tag->mapWordCnt.put(tag, 1));
		listNoun.retainAll(listTag);
		
		for (String noun : listNoun) {
			mapWordCnt.put(noun, mapWordCnt.get(noun) + 1);
		}
		return mapWordCnt;
	}
}
