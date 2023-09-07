package www.dream.bbs.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PersonVO;
import www.dream.bbs.party.service.PartyService;

@RestController  // Container에 담기도록 지정
@CrossOrigin
@RequestMapping("/party")
public class PartyController {
	@Autowired
	private PartyService partyService;
	
	// /party/listAllMember?ownerId=0000
	@GetMapping("/listAllMember")
	public ResponseEntity<List<PersonVO>> listAllMember(/* @RequestParam("ownerId") */ String ownerId) {
		return ResponseEntity.ok(partyService.listAllMember(ownerId));
	}
	
	@PostMapping("/createOrganizaiton")
	public ResponseEntity<Integer> createOrganizaiton(OrganizationVO organizaiton) { // garbage collection
		return ResponseEntity.ok(partyService.createOrganizaiton(organizaiton));
	}
	
	@PostMapping("/createManager")
	public ResponseEntity<Integer> createManager(OrganizationVO organizaiton, PersonVO person) {
		return ResponseEntity.ok(partyService.createManager(organizaiton, person));
	}
	
	//party/annonymous/checkNick?nick=rfwref
	@GetMapping("/annonymous/checkNick")
	public ResponseEntity<Boolean> checkNick(String nick) {
		return ResponseEntity.ok(partyService.checkNick(nick));
	}
	
	//party/annonymous/createMember
	@PostMapping("/annonymous/createMember")
	public ResponseEntity<Integer> createMember(@RequestBody PersonVO person) {
		return ResponseEntity.ok(partyService.createMember(person));
	}
}
