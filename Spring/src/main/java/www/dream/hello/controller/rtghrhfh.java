package www.dream.hello.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.dream.hello.model.MemberVO;

@RestController
@RequestMapping("/rapi")
public class rtghrhfh {
	@Value("${news.imgdir}")
	String myConfig;
	
	// rapi/tgrtghrh?gbh=fdgdfg
	@GetMapping("/tgrtghrh")
	public List<String> tgtgtg(@RequestParam(value="gbh") String msg) {
		List<String> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(myConfig + val + msg));
		return ret;
	}
	
	@GetMapping("/member/all")
	public List<MemberVO> listAllMembers(@RequestParam(value="gbh") String msg) {
		List<MemberVO> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(new MemberVO(msg + val, val, "tgrtgrt")));
		return ret;
	}
	
	@GetMapping(value="/member/frtgterge", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MemberVO> listAllgtrgMembers(@RequestParam(value="gbh") String msg) {
		List<MemberVO> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(new MemberVO(msg + val, val, "gthgrt")));
		return ret;
	}
	
}
