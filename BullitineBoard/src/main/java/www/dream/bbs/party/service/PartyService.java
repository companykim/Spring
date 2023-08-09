package www.dream.bbs.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.PartyVO;

@Service   // Container에 담기도록 지정
public class PartyService {
	@Autowired
	private PartyMapper partyMapper;
	
	public List<PartyVO> listAll() {
		return partyMapper.listAll();
	}
}
