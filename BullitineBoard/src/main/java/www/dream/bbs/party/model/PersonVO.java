package www.dream.bbs.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonVO extends PartyVO {
	private boolean sex;
	
	public PersonVO(String name, String nick, String pwd, 
			List<ContactPointVO> listContactPoint, boolean sex) {
		super(name, nick, pwd, listContactPoint);
		this.sex = sex;
	}
}
