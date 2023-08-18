package com.example.demo.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import a.b.c.model.MemberVO;

@Service
public class RestTemplateService {

	public String getName() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
		.path("/a").encode().build().toUri();

		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> res = rt.getForEntity(uri, String.class);

		return res.getBody();
	}

	// 예제 12.4
	public ResponseEntity<MemberVO> postWithParamAndBody() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
		.path("/a/m").encode().build().toUri();

		MemberVO memberDto = new MemberVO("frgrt", 27);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberVO> responseEntity = 
				restTemplate.postForEntity(uri, memberDto, 
				MemberVO.class);

		return responseEntity;
	}
}
