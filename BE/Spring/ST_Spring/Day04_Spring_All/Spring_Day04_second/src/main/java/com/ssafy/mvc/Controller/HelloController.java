package com.ssafy.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HelloController {
	
	//href = "hello"로 넘어왔다만 컨트롤러에서 맵핑되는 메서드를 찾음
	@GetMapping({"/hello"})
	public String hello() {
		System.out.println("getMapping 되어 hello 메서드 발동하고 hello.jsp로 return: 포워드");
		return "hello";
	}

}
