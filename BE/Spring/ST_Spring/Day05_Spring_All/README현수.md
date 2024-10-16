# 1번째 시도 : 의존성 차이 + 로그인 유무에 따른 Interceptor T/F (2개의 클래스 추가)

### 1.  시작 설정 : 3가지 의존성의 차이

        - API는 인터페이스의 느낌 -> jstl은 인터페이스에 대한 구현체
        - Tomcat Jasper는 `src/main/webapp/WEB-INF/ ` 의 구조 안에 있는 jsp를 읽어오게 되었어 맞춰줘야한다
        - 위를 이유로 static 안에 있는 jsp는 에러가 난다. 
        - index.html은 꼭 static 안에 넣어야 에러가 안남 -> 어제는 views 안에 있는게 됐는데 왜그러니
        - 경로를 직접 타이핑해서 들어가는 것은 컨트롤러를 거치지 않고, 바로 jsp로 이동



| **구분**           | **Tomcat Embed Core**                             | **JSTL API**                                | **JSTL 구현체**                             |
|--------------------|---------------------------------------------------|---------------------------------------------|--------------------------------------------|
| **Group ID**       | `org.apache.tomcat.embed`                         | `jakarta.servlet.jsp.jstl-api`              | `org.glassfish.web`                        |
| **Artifact ID**    | `tomcat-embed-jasper`                               | `jakarta.servlet.jsp.jstl-api`              | `jakarta.servlet.jsp.jstl`                 |
| **역할**            | 톰캣 서버를 애플리케이션에 임베디드 형태로 포함 | JSTL 태그 라이브러리의 API 정의 제공       | JSTL API를 구현한 실제 동작 코드 제공     |
| **포함 기능**      | 톰캣 웹 서버 코어 기능                           | JSTL의 인터페이스 및 시그니처 정의         | API에서 정의한 태그의 실제 동작 구현      |
| **필수 여부**      | 선택적 (임베디드 톰캣을 쓸 경우)                 | JSTL 사용 시 필수                           | JSTL 사용 시 필수                           |
| **제공 태그 예시** | -                                                 | `<c:forEach>` 등의 태그 정의               | `<c:forEach>` 등의 태그 기능 구현          |
| **사용 예시**      | Spring Boot 프로젝트 내 임베디드 서버             | JSTL 태그가 사용된 JSP 페이지 개발 시 사용 | 태그가 실제로 작동하도록 하기 위해 필요   |
| **비고**           | 톰캣이 없는 환경에서는 불필요                     | 단독으로는 동작하지 않음                   | API와 함께 사용해야 함                     |

### 2. 에러발생 1 :  EL 표기식에서의 따옴표 주의
```
	<h1>HelloJsp</h1>
	<!-- 여기서 로그인을 확인 -->
	<!-- 따옴표를 써줘야함 -> 그래서 에러남..-->
	<c:if test="${empty loginUser }">
		<!-- 비어있다면 로그인 해라 -->
		<form action = "login" method="post">
			<fieldset>
				<label>아이디</label>
				<input type="text" name ="id"><br>
				<label>비밀번호</label>
				<input type="password" name ="pw">
			</fieldset>
			<br>
			<button>로그인</button>
		</form>
	</c:if>

```

### 3. interceptor를 구현 : 로그인 정보가 없을 경우(또는 원하는 ID/PW가 아닐 경우)는 `regist` 경로를 넣어도 login을 요구하게 함
- interceptor 클래스 안에 로그인의 유무를 체크해서 T/F 반환해주는 preHandle을 만들어두고, Webconfig 안에서 의존성과 addinterceptors 진행

- 의존성 주입의 방법 3가지 : ~~멤버 필드 주입~~, 생성자 주입, 설정자 주입 → logininterceptor를 인자로 미리 호출을 해두고 생성자나 설정자 안에 this 통해 의존성 주입, 또한 이때 매개변수를 넣어줘야함
- 틀린 아이디와 비밀 번호를 넣었을 때 다시 로그인으로 리다이렉트하는 기능을 까먹음
- 컨트롤러에서 postmapping 메서드 안에 넣어줘야함
- PostMapping 된  login method에서 원하는ID와 PW를 확인해줌.



     #### (1) config.WebConfig.class 추가

        ```
        
        @Configuration
        public class WebConfig implements WebMvcConfigurer{
            //의존성 주입 (필드주입,생성자주입,설정자주입) -> 필드 주입은 약식이므로 추천하지는 않음
            @Autowired
            private LoginInterceptor loginInterceptor;

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginInterceptor).addPathPatterns("/regist").excludePathPatterns("/hello");   
            }
        }

        ```
     #### (2) interceptor.loginInterceptor.class 추가

        ```
        //
        @Component
        public class LoginInterceptor implements HandlerInterceptor{
            
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                //로그인 했니? 
                HttpSession session = request.getSession();
                
                if(session.getAttribute("loginUser") == null) {
                    response.sendRedirect("login");
                    return false;
                }
                
                return true;
            }

        }

        ```
-------
**이렇게 완성했을 때, filter를 제외하고 띵균쌤 코드와의 차이는 무엇?**
1. 기능은 같지만, redirect 로 갈지 return "jsp주소"로 갈지를 잘 구분해서 맵핑

-----
# 2번째 시도 : 
### 1.  시작 설정 : 3가지 의존성의 차이