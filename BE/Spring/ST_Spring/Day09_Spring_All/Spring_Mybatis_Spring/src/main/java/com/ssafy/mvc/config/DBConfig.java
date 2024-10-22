package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//getMapper을 위해서 MapperScan을 함 
//최상위패키지 = DAO(메서드를 선언해둔 인터페이스)
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
public class DBConfig {

}
