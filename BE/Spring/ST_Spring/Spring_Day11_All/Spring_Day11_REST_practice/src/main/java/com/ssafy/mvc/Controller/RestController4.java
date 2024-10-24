package com.ssafy.mvc.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
//위 어노테이션을 추가하면서 각각 해주던 ResponseBody를 한번에 처리
//컨트롤러 + 광역 ResponseBody = RestController
//RequestMapping = rest2로 시작하는 클라이언트 요청은 모두 여기로 들어옴
@RestController
@RequestMapping("/rest4")
public class RestController4 {
	//
	
	@GetMapping({"/board1/{id}"})
	public String test1(@PathVariable int id) {
		//뭄
		return id+": board";
	}
	
	
	@GetMapping({"/board2/{id}"})
	public String test2(@PathVariable("id") int some) {
		//뭄
		return some+": board";
	}
	
	@GetMapping({"/board3/{id}/reviews/{rid}"})
	public String test2(@PathVariable("id") int some, @PathVariable("rid") int some2) {
		//뭄
		return some+": board : rid : "+some2;
	}
	
	
	
	


}
