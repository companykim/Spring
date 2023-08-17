package www.dream.bbs.party.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonVO extends PartyVO {
	private boolean sex;
	
	public PersonVO(String name, String nick, String pwd, 
			List<ContactPointVO> listContactPoint, boolean sex) {
		super(name, nick, pwd, listContactPoint);
		this.sex = sex;
	}
}
