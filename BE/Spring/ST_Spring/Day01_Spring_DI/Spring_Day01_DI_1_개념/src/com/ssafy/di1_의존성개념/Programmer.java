package com.ssafy.di1_의존성개념;

//컴퓨터 필요해!
public class Programmer {
	//필드로 따로 가짐
	private Desktop desktop;
	
	
	//기본 생성자인 Programmer에 desktop이라는 의존성을 심어주는 것.
	public Programmer() {
		//프로그래머를 한명 고용했다면 "묻지도 따지지도 않고" 컴퓨터를 한대 새로 사줌.
		
		//desktop 초기화해주는 코드 -> 강한 결합 : 다른 종류의 컴퓨터를 사용하고 싶다면
		//programmer 클래스 자체를 수정해야함.
		this.desktop = new Desktop();
	}
	
	/**
	    // 외부에서 Desktop 객체를 주입받는 생성자 -> 유연성이 높아짐.
    	public Programmer(Desktop desktop) {
        this.desktop = desktop;
    }
	 */
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발을 합니다.");
	}
}


/*
 * 기본 생성자(아무런 인자없이 호출 가능)의 역할
 * 1. 객체를 생성했을 때, 객체를 초기화 할 수 있으며, 클래스 내에서 초기화해야 할 필드가
 * 있는 경우 기본값을 설정할 수도 있다.
 * 2. 자동 생성 : 클래스에 따로 생성해주지않았다면, 컴파일러가 자동생성해줌.
 * -> 하지만 파라미터가 있는 생성자를 선언한 경우 자동생성은 없으니 유의
 * 
 * 매개변수가 있는 생성자를 만들어줘도 기본 생성자를 만들어주는 이유?
 * -> 나중에 매개변수를 입력하지않고 객체를 호출했을 경우의 에러를 방지하기 위해서!
 * 
 *  Spring은 Reflection을 이용해서 객체를 생성한다. -> 모든 생성자를 읽어올 수 있음.
 *  
 * 
 * 
 * 
 */
