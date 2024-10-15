package com.ssafy.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {
	
	//이게 있어야 href = "hello"로 갔다
	@GetMapping("hello1")
	public String hello(Model model){
		model.addAttribute("msg", "Hello Controller안의 메시지");
		
		return "redirect:hello2"; //포워드로 다시 보내줌
		
	}
	
	@GetMapping("hello2")
	public String hello() {
		return "test";
	}

}
