package www.dream.bbs.party.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.board.framework.model.MasterEntity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class PartyVO extends MasterEntity {
	private String name;
	private boolean sex;
	
	// 연락처 목록
	private List<ContactPointVO> listContactPoint = new ArrayList<>(); 
	
	public PartyVO(String name, boolean sex) {
		this.name = name;
		this.sex = sex;
	}
	
	public void addCP(ContactPointVO cp) {
		// null pointer
		listContactPoint.add(cp);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", name=" + name + ", sex=" + sex + ", 연락처들=" + listContactPoint;
	}
}
