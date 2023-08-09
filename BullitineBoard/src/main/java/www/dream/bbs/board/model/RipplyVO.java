package www.dream.bbs.board.model;

import java.util.List;

import www.dream.bbs.board.framework.model.MasterEntity;
import www.dream.bbs.party.model.PartyVO;

public class RipplyVO extends MasterEntity {
	private PartyVO writer; // 게시물 작성자
	private String content; // 내용
	private String hierarch;
	// 대댓 구조 만들기는 어떻게?
	private List<RipplyVO> listRipply;
}
