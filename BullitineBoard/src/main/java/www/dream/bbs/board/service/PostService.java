package www.dream.bbs.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.RipplyVO;

@Service   // Container에 담기도록 지정
public class PostService {
	@Autowired
	private PostMapper postMapper;
	
	/** 게시판의 모든 원글 조회*/
	public List<PostVO> listAllPost(String boardId) {
		return postMapper.listAllPost(boardId);
	}
	
	/** 원글 상세, 첨부파일 목록, 댓글, 대댓 목록이 내부 변수에 채워짐 */
	public PostVO findById(String id) {
		// postMapper.findById(id)는 id의 primary key 특성으로 사전순서가 보장되어 있음.
		List<RipplyVO> oneDimList = postMapper.findById(id);
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
	
	/** 게시판에 원글 달기 */
	public int createPost(PostVO post) {
		return postMapper.createPost(post);
	}
	/** 댓글 달기, parent의 hid의 연결된 hid 만들기 */
	public int createRipply(RipplyVO parent, RipplyVO reply) {
		return postMapper.createRipply(parent, reply);
	}
	
	/** */
	public int updatePost(PostVO reply) {
		return postMapper.updatePost(reply);
	}
	/** */
	public int updateRipply(RipplyVO reply) {
		return postMapper.updateRipply(reply);
	}
	
	/** hid like로 지우기 */
	public int deleteRipply(String id) {
		return postMapper.deleteRipply(id);
	}
}
