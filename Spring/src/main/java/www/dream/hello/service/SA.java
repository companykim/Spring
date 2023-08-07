package www.dream.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.hello.model.MemberDTO;
import www.dream.hello.model.MemberVO;

@Service
public class SA {
	@Autowired
	private SB sb;
	
	public MemberVO gdtgrth(MemberDTO member) {
		MemberVO ret = new MemberVO(member.getId(), member.getBal() + 9999, member.getPwd());
		return ret;
	}
}
