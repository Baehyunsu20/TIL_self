package com.ssafy.mvc.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
//위 어노테이션을 추가하면서 각각 해주던 ResponseBody를 한번에 처리
//컨트롤러 + 광역 ResponseBody = RestController
//RequestMapping = rest2로 시작하는 클라이언트 요청은 모두 여기로 들어옴
@RestController
@RequestMapping("/rest5")
public class RestController5 {
	
	//폼데이터로 넘겨 왔을 경우
	@PostMapping({"/board1"})
	public String test1(@ModelAttribute User u) {
		//뭄
		return u.toString();
	}
	@PostMapping({"/board2"})
	public String test2(@RequestBody User u) {
		//뭄
		return u.toString();
	}
	
}
