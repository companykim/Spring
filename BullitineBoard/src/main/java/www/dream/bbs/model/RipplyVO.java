package www.dream.bbs.model;

import www.dream.bbs.framework.model.MasterEntity;
import www.dream.bbs.party.model.PartyVO;

public class RipplyVO extends MasterEntity {
	private PartyVO writer; // 게시물 작성자
	private String content; // 내용
}
