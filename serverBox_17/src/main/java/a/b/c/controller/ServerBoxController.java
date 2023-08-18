package a.b.c.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.b.c.model.MemberVO;

@RestController
@RequestMapping("/a")
public class ServerBoxController {
	@GetMapping
	public String get() {
		return "hello gregedthdbdhddthsrfg";
	}
	
	@PostMapping("/m")
	public ResponseEntity<MemberVO> getMember(@RequestBody MemberVO mem) {
		return ResponseEntity.ok(new MemberVO(mem.name() + "ggf fh", 19));
	}
}
