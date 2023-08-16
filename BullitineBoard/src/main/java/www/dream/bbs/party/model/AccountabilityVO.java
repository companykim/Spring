package www.dream.bbs.party.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.board.framework.model.MasterEntity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AccountabilityVO extends MasterEntity {
	private String accountType;
	private String ownerId; // 주인으로서
	private String responsId; // 대상으로서
}
