package com.ssafy.first.mvc.interceptor;

import java.io.IOException;

import org.aopalliance.intercept.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//애매한 요소들(interceptor)은 다 Component로 넣어줌
@Component
public class loginInterceptor implements HandlerInterceptor {

	//생성자를 굳이 만들 필요가 없다
	public loginInterceptor() {
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//여기서 로그인 판단해서 T/F 를 반환해줌
		//로그인을 확인하기 위해 session을 가져와서 판단해주기
		HttpSession s = request.getSession();
		if(s.getAttribute("loginUser")==null) {
			//리다이렉트로 로그인 할 수 있게 보냄 -> 로그인 맵핍으로 보냄(getMapping으로 가네)
			response.sendRedirect("/login");
			return false;
		}
		
		
		return true; //
	}
	
	
	

}
