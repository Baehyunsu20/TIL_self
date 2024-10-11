package com.ssafy.di1_의존성개념;

public class Test {
	public static void main(String[] args) {
		//프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		//프로그래머는 데스크톱이 있어야 일을 할 수 있다 
		// Programmer 기본 생성자에 데스크톱을 직접 생성해서 넣어줬음.
		Programmer p = new Programmer();
		
		p.coding();
		
		
	}
}
/*
 * Class A 객체가 어떤 일을 처리하기 위해서 Class B의 객체의 도움을 받아야만 일을 처리할 수 있다
 * = Class A(Programmer.class)는 Class B(desktop.class)에 의존한다
 * 
 */
