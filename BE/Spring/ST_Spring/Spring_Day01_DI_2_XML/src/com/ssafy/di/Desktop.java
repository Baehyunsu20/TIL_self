package com.ssafy.di;

public class Desktop implements Computer {
	
	public Desktop() {
		
		System.out.println("생성되었습니다");
	}

	public String getInfo() {
		
		return "데스크톱";
	}
	

}
