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

import www.dream.bbs.party.model.ContactPointVO;
import www.dream.bbs.party.model.OrganizationVO;

@ExtendWith(SpringExtension.class)
@MybatisTest
//실 데이터베이스에 연결 시 필요한 어노테이션
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PartyMapperTest {
    @Autowired
    private PartyMapper mapper;
    
    @Test
    @DisplayName("createOrganizaiton Test")
    @Rollback(false)
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
}
