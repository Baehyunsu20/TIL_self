package com.ssafy.mvc.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mvc.model.dto.User;

@Controller
public class RestController1 {
	//
	
	@GetMapping({"/rest1/test1"})
	public String test1() {
		//뭄
		return "Hello REST API";
	}
	
	@GetMapping({"/rest1/test2"})
	@ResponseBody
	public String test2() {
		return "Hello REST API";
	}
	
	@GetMapping({"/rest1/test3"})
	@ResponseBody
	public Map<String, String> test3() {
		//Map = 키 :밸류
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");

		return data;
	}
	
	@GetMapping({"/rest1/test4"})
	@ResponseBody
	public User test4() {
		User user = new User("ssafy", "1234", "배현수");
		return user;
	}
	
	//내가 여러개를 보내고 싶을떄
	@GetMapping({"/rest1/test5"})
	@ResponseBody
	public List<User> test5() {
		List<User> users = new ArrayList<>();
		users.add(new User("ssafy", "1234", "배현수"));
		users.add(new User("ssafy", "1234", "고민서"));
		return users;
	}
	
	


}
