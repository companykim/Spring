package www.dream.bbs.party.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.board.framework.model.MasterEntity;
import www.dream.bbs.board.framework.property.anno.TargetProperty;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class PartyVO extends MasterEntity {
	@TargetProperty
	private String name;
	private String nick;  
	//@JsonIgnore // pwd는 화면에 노출하는 대상이 아님! 보안!
	private String pwd;     
	
	// 연락처 목록
	private List<ContactPointVO> listContactPoint = new ArrayList<>(); 
	private List<AccountabilityVO> listAccountability = new ArrayList<>(); 

	public PartyVO(String name, String nick, String pwd, List<ContactPointVO> listContactPoint) {
		this.name = name;
		this.nick = nick;
		this.pwd = pwd;
		this.listContactPoint = listContactPoint;
	}
	
	public void addCP(ContactPointVO cp) {
		// null pointer
		listContactPoint.add(cp);
	}
}
