package www.dream.bbs.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.party.model.PartyVO;
import www.dream.bbs.party.service.PartyService;

@RestController  // Container에 담기도록 지정
@RequestMapping("/party")
public class PartyController {
	@Autowired
	private PartyService partyService;
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAll() {
		List<PartyVO> list = partyService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
