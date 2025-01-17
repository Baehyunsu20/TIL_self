package com.ssafy.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("배현수가 만든 보드 대문")
	              .description("게시판 API 입니다")
	              .version("v0.0.1")
	              .license(new License().name("hs").url("https://www.ssafy.com")))
	              .externalDocs(new ExternalDocumentation()
	              .description("개큰 표현")
	              .url("https://www.naver.com"));
	  }



}
