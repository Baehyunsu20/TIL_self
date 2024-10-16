package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//HelloController를 등록하는 Annotation만 하면 Bean으로 자동 등록
@Controller
public class HelloController {
	
	@GetMapping("/hello1")
	public String hello(Model model){
		model.addAttribute("msg", "Hello Controller안의 메시지");
		return "hello"; //return에 들어가는 것은 앞뒤로 prefix와 suffix로 연결된 파일 위치임
		
	}
	
}
