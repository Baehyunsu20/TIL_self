package com.ssafy.mvc.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//자동차면 자동차 컨트롤러, 사람이면 사람컨트롤러 -> 기능별로 나눠서 컨트롤러 클래스를 만들어주는게 좋다.

//annotation을 해주면 Bean으로 등록이 된 것
@Controller
public class UserController {
	
	//정석 : 내가 Service를 의존성 주입을 받아야한다.(3가지 Autowired)
	
	
	//url을 이용해서 들어오는 방식은 get 방식 -> getmapping / 
	@GetMapping("/login")
	public String loginForm() {
		//앞에는 WEB-INF가 있고,  그 밑에 views, user, 맨 아래에 loginForm
		return "/user/loginForm";
	}
	
	
	//각 hello에 번호를 붙여서 다시 공부해보기
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		//userService 라는 친구를 통해서 실제로 id. pw를 이용하여 DB를 확인하고, 실제 유저가 맞는지 확인해야함
//		//그 다음엔 세션에 정보를 저장해야함
//		
//		System.out.println(id +" "+ pw);
//		//포워딩 방식 -> hello boot가 안뜸 -> helloController가 작동을 안함
//		//hello 페이지로 이동한 것 : 포워딩이니까 msg가 없어서 공백처리된것
//		return  "hello"; 
//		
//		//리다이렉트 방식 -> hello boot가 뜸 : hello라는 요청을 보낸 것 -> HelloController의 getMapping이 동작된것임
////		return "redirect:hello"; 
//		
//	}
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute User user, HttpServletRequest request) {
//		System.out.println(user);
//		
//		//이제 해야할 것 : 세션에 저장 -> 세션을 가져와야함.
//		
//		//방법 1
//		HttpSession session = request.getSession();
//		
//		
//		
//		return "redirect:hello"; //hello 요청을 다시 req하는 것이므로 helloController작동
//		
//	}
//	
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
		
		//이제 해야할 것 : 세션에 저장 -> 세션을 가져와야함.
		
		//방법 2
//		session.setAttribute("loginUser", user); //pw까지 같이 저장 -> 보안상 민감
		//지금은 서비스를 구현하지않아서 입력받은 id를 바로 넣았지만
		//service를 구현하고 난 뒤, 인증 받은 정보만을 넣어라
		session.setAttribute("loginUser", user.getId()); //pw까지 같이 저장 -> 보안상 민감

		
		return "redirect:hello"; //hello 요청을 다시 req하는 것이므로 helloController작동
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		//로그아웃하는 방법
		//1. 세션에서 유저 속성을 지우는 작업
		session.removeAttribute("loginUser");
		//2. 세션 정보를 초기화
//		session.invalidate();
//		return "redirect:/"; //포트번호까지만 간다 =-> 인덱스페이지로 간다
		return "redirect:hello";
		
	}
	
	
	
	
	

}
