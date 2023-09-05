package www.dream.bbs.board.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.bbs.board.framework.model.MasterEntity;
import www.dream.bbs.board.framework.property.anno.TargetProperty;
import www.dream.bbs.party.model.PartyVO;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RipplyVO extends MasterEntity {
	@TargetProperty
	private PartyVO writer; // 게시물 작성자
	@TargetProperty
	private String content; // 내용
	private int hTier;
	// 대댓 구조 만들기는 어떻게?
	private List<RipplyVO> listReply;
	
	public String extractParentId() {
		String myId = super.getId();
		int len = myId.length();
		return myId.substring(0, len - ID_LENGTH);
	}

	public void appendReply(RipplyVO reply) {
		if (listReply == null)
			listReply = new ArrayList<>();
		listReply.add(reply);
	}
}
