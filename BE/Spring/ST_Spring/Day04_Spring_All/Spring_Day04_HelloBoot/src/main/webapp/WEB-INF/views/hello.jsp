<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri = "jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<!-- 로그인 안했다면 (로그인 페이지로 이동) -->
	<c:if test ="${empty loginUser }">
	<!--  main에서 처리하고 있기 때문에 / 가 있고 없고가 둘다 된다 -> 나중에 depth가 더 생기면 
	당연히 슬래쉬 고려해야함 -->
	
	<!-- 작동 흐름 : login을 클릭하면 서버에 요청 감 
	-> 디스패처서블릿 동작 -> "어떤 컨트롤러가 이런 요청을 처리할 수 있는지" 판단  -->
	<a href = "login">로그인</a>
	
	</c:if>
	
	
	<!-- 로그인 O : (로그아웃)  -->
	<c:if test ="${not empty loginUser }">
		<Span>${loginUser } 님 반갑습니다.</Span>
		
		<!-- href 안에 들어가는 경로의 대소문자 잘 확인하기
		경로를 넣었으면 get 요청이다 -->
		<a href = "/logout">로그아웃</a>
	</c:if>

	<h2>HelloJSP : hello.jsp 파일 노출입니다</h2>
	<h3>${msg }</h3>

</body>
</html>