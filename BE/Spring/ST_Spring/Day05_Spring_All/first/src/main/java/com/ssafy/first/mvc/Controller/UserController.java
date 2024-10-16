package com.ssafy.first.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.first.mvc.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	@GetMapping({"/hello"})
	public String hello() {
		return "/hello"; //index.jsp에서 hello를 클릭했을 때 작동
	}
	
	@PostMapping({"/login"})
	public String login(@ModelAttribute User user, HttpSession session) {
		//여러번 하게되면 loginUser로 덮어써진다.
		
		if(user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		else {
			//맞는 로그인이 아니므로 무한 로그인 루프
			return "redirect:login";
		}

	}
	
	
	
	@GetMapping({"/login"})
	public String login() {
		//여러번 하게되면 loginUser로 덮어써진다.
		return "redirect:hello";

	}
	
	@GetMapping({"/logout"})
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		
		return "redirect:hello";
	}
	
	//이제 여기서 interception의 역할이 들어가면 될 듯 
	@GetMapping({"/regist"})
	public String regist(HttpSession session) {
//		session.removeAttribute("loginUser");
		
		//여기서는 슬래쉬를 꼭 넣어줘야함 -> 안 붙여주면 그냥 prefix에 그렇게 됨.
		//리다이렉트로 하면 regist.jsp가 아니라 리다이렉트 초과 에러 발생
		return "/regist";
	}
	

}
