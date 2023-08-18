package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RestTemplateService;

import a.b.c.model.MemberVO;

@RestController
@RequestMapping("/a")
public class MSAClientServer {
	@Autowired
	private RestTemplateService rts;
	
	@GetMapping
	public String get() {
		return rts.getName();
	}
	
	@GetMapping("/post")
	public MemberVO getoo() {
		ResponseEntity<MemberVO> re = rts.postWithParamAndBody();
		return re.getBody();
	}
}
