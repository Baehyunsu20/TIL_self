package com.ssafy.first.mvc.dto;

import org.springframework.stereotype.Component;

//이거 꼭 해줘야하나..? 헷갈리네
@Component
public class User {
	private String id;
	private String pw;
	
	public User() {
	}
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
}
