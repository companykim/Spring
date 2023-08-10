package www.dream.bbs.board.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostVO extends RipplyVO {
	/* 아래 속성은 게시글 일때만 활용되는 */
	private BoardVO boardVO;
	private String title;
	private int readCnt;
	private int likeCnt;
	private int disCnt;

}
