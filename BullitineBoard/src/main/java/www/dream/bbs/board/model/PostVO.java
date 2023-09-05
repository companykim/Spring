package www.dream.bbs.board.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.bbs.board.framework.property.anno.TargetProperty;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostVO extends RipplyVO {
	/* 아래 속성은 게시글 일때만 활용되는 */
	private BoardVO boardVO;
	@TargetProperty
	private String title;
	private int readCnt;
	private int likeCnt;
	private int disCnt;
	
	
	// VO(정보를 공유한다.) ? DTO (화면에서 시스템으로 정보를 공유)
	private List<String> listTag;

}
