package com.ssafy.first.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.first.mvc.interceptor.loginInterceptor;

//이것은 설정을 모아둔 클래스이다.
@Configuration
public class Webconfig implements WebMvcConfigurer {
	//아까 만들어준 loginInterceptor에 대한 의존성을 주입해줌
	//	@Autowired
//		private loginInterceptor interceptor; //필드 주입 -> 추천하는 방법이 아님
	
	//아까 나머지 두가지 방법 -> 생성자 주입, 설정자(세터)주입
	
	//1. 생성자 주입 : 
	private loginInterceptor interceptor;
	@Autowired
	public Webconfig(loginInterceptor interceptor){
		this.interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//re
		registry.addInterceptor(interceptor).addPathPatterns("/regist");

	}
	
	

}
