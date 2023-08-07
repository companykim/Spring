package www.dream.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.dream.hello.model.MemberDTO;
import www.dream.hello.model.MemberVO;
import www.dream.hello.service.SA;

@Controller
@RequestMapping("/test")
public class HelloController {
	@Autowired
	private SA sa;
	
	@GetMapping("/hello")
	public String tgtgtg() {
		return "calcWithBean";
	}
	
	///test/h2?msg=hjhjhjhj&age=888
	@GetMapping("/h2")
	public String jyhdfshgfvbiyut(String msg, int age, Model objToJsp) {
		objToJsp.addAttribute("msg", msg);
		objToJsp.addAttribute("age", age);
		return "h2"; 
	}

	///test/h3?id=hjntfv&bal=78965&pwd=iytgb
	@GetMapping("/h3")
	public String jyhdzdfsaqfshgfvbiyut(MemberDTO member, Model objToJsp) {
		objToJsp.addAttribute("member", member);
		return "h3"; 
	}

	///test/h4?id=hjntfv&bal=10&pwd=iytgb
	@GetMapping("/h4")
	public String jyhafdgadzdfsaqfshgfvbiyut(MemberDTO member, Model objToJsp) {
		MemberVO serviced = sa.gdtgrth(member);
		objToJsp.addAttribute("serviced", serviced);
		return "h4"; 
	}

	@GetMapping("/ehco")
	@ResponseBody
	public String jyhfdgfjswvbiyut(@RequestParam(value = "trt") String msg) {
		return msg; 
	}

	//{} path variable
	@GetMapping("/umdl1/{ghgtggg}")
	public String jyhfdgffghjswvbiyut(@PathVariable String ghgtggg, Model objToJsp) {
		objToJsp.addAttribute("wgfsbhwwe", ghgtggg + "jhgvgvjvbfv ogfifb sfd");
		return "umd1";
	}
}
