package www.dream.bbs.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.RipplyVO;

@Mapper   // Container에 담기도록 지정
public interface PostMapper {
	// LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<PostVO> listAllPost(String boardId); // 모든 정보를 간략하게 출력
	public List<RipplyVO> findById(String id); 
	
	/** affected row counts */
	public int createPost(PostVO post);
	public int createRipply(@Param("parent")RipplyVO parent, @Param("reply")RipplyVO reply);

	public int updatePost(PostVO reply);
	public int updateRipply(RipplyVO reply);

	public int deleteRipply(String id);
}
