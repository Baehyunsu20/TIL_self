package com.ssafy.mvc.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.userService;

@RestController
@RequestMapping("api-u")
public class UserController {
	
	//유저서비스에 대한 의존성 주입
	private final userService userService;

	public UserController(com.ssafy.mvc.model.service.userService userService) {
		this.userService = userService;
	}
	//기능 추가
	//join해서 가져오는 거로
	@GetMapping("/user")
	public ResponseEntity<?> list(){
		//selectall이라 잘 나오는 것을 볼 수 있음
		List<User> nn = userService.getUserList();
		return new ResponseEntity<List<User>>(nn, HttpStatus.OK);
	}
	

}
