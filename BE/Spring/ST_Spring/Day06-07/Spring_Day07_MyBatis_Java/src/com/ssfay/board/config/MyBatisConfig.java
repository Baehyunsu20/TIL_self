package com.ssfay.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//boot로 넘어가서 bean으로 등록하면 컨테이너가 알아서 해줌
public class MyBatisConfig {
	//공장을 세워서 쓰기 위함이다
	private static SqlSessionFactory factory;

	
	static {
		String resource = "mybatis-config.xml";
		 try(InputStream inputStream = Resources.getResourceAsStream(resource)){
			 factory = new SqlSessionFactoryBuilder().build(inputStream);
			 System.out.println("성공"); 
		 }
		 catch (IOException e) {
			System.out.println("실패"); 
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
