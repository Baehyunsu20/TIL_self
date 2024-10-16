package com.ssafy.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	//로그인버튼을 눌렀을 경우 : post로 로그인 정보가 넘어옴
	//form으로 보낸 정보를 User의 꼴로 가져와서 session에 저장
	@PostMapping({"/login"})
	public String login(@ModelAttribute User user, HttpSession session) {
		
		session.setAttribute("loginUser", user.getId());
		return "hello";
		
	}
	
	//로그아웃의 경우는 href로 컨트롤러에 넘김 -> get
	@GetMapping({"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		//return "index" //포워드는 jsp주소로 이동하므로 지정
		
	}

}
