package www.dream.bbs.party.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.ContactPointVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PersonVO;

@ExtendWith(SpringExtension.class)
@MybatisTest
//실 데이터베이스에 연결 시 필요한 어노테이션
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PartyMapperTest {
    @Autowired
    private PartyMapper mapper;
    
    //@Test
    @DisplayName("createOrganizaiton Test")
    @Rollback(true)
    public void testCreateOrganizaiton() {
    	try {
    		PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
    		String pwd = pwdEnc.encode("dream");

    		List<ContactPointVO> listContactPoint = new ArrayList<>();
    		listContactPoint.add(new ContactPointVO("hand phone number", "010-0000-0000"));
    		listContactPoint.add(new ContactPointVO("home address", "경기 용인 수지 000로"));
    	
    		
    		OrganizationVO dream = new OrganizationVO("Dream Company", "dream", pwd, listContactPoint);
    		int cnt = mapper.createOrganizaiton(dream);
    		System.out.println(dream.getId());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @DisplayName("createManager Test")
    @Rollback(false)
    public void testCreateManager() {
    	try {
    		PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
    		String pwd = pwdEnc.encode("kim");

    		List<ContactPointVO> listContactPoint = new ArrayList<>();
    		listContactPoint.add(new ContactPointVO("hand phone number", "010-0000-0000"));
    		listContactPoint.add(new ContactPointVO("home address", "경기 용인 수지 000로"));
    	
    		PersonVO root = new PersonVO("김기업", "kim", pwd, listContactPoint, true);
    		int cnt = mapper.createPerson(root);
    		mapper.createAccountability(new AccountabilityVO("manager", "kim", root.getId()));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //@Test
    @DisplayName("createMemeber Test")
    @Rollback(false)
    public void testCreateMember() {
    	try {
    		PasswordEncoder pwdEnc = new BCryptPasswordEncoder();
    		String pwd = pwdEnc.encode("lee");

    		List<ContactPointVO> listContactPoint = new ArrayList<>();
    		listContactPoint.add(new ContactPointVO("hand phone number", "010-7778-0999"));
    		listContactPoint.add(new ContactPointVO("home address", "경기 용인 기흥 000로"));
    	
    		PersonVO lee = new PersonVO("이길동", "lee", pwd, listContactPoint, true);
    		int cnt = mapper.createPerson(lee);
    		mapper.createAccountability(new AccountabilityVO("member", "0000", lee.getId()));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
