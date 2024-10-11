package com.ssafy.di;

//
public class Programmer {
	private Computer computer;
	
	
	public Programmer() {
		
	}
	//객체 생성 의존성을 제거한 상태
	public Programmer(Computer computer) {
		//가지고 있는 데스크탑 한개를 줌.
		this.computer = computer;
		
	}
	
	
	//설정자를 이용해서 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
	
	public void coding() {
		System.out.println(computer.getInfo() + " 으로 개발을 합니다.");
	}
	
	

}
