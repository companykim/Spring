package www.dream.bbs.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PartyVO;
import www.dream.bbs.party.model.PersonVO;
import www.dream.bbs.security.dto.SignInResultDto;
import www.dream.bbs.security.dto.SignUpResultDto;

@Service   // Container에 담기도록 지정
public class PartyService implements UserDetailsService {
	@Autowired
	private PartyMapper partyMapper;
	
	@Autowired
	private PasswordEncoder pwdEnc;

	public List<PersonVO> listAllMember(String ownerId) {
		return partyMapper.listAllMember(ownerId);
	}
	
	public int createOrganizaiton(OrganizationVO organizaiton) { // garbage collection
		organizaiton.encodePwd(pwdEnc);
		return partyMapper.createOrganizaiton(organizaiton);
	}
	
	public int createManager(OrganizationVO organizaiton, PersonVO person) {
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);
		
		partyMapper.createAccountability(new AccountabilityVO("manager", organizaiton.getId(), person.getId()));
		return cnt;
	}
	
	/** 회원 가입 */
	public int createMember(OrganizationVO organizaiton, PersonVO person) {
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);
		
		partyMapper.createAccountability(new AccountabilityVO("member", organizaiton.getId(), person.getId()));
		return cnt;
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return partyMapper.findByNick(username);
	}
}
