<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello page</title>
</head>
<body>
	<h1>login 요소를 만들어보자</h1>
	<!-- 비어있을 경우 -> 로그인하기 -->
	<c:if test="${empty loginUser }">
	<!-- 컨트롤러에서 login을 찾아감 : PostMapping -->
		<form action = "login" method = "POST">
			<fieldset>
				<label>아이디</label>
				<input type = "text" name="id"><br>
				<label>비밀번호</label>
				<input type = "password" name="pw"><br>
			</fieldset>
			<button>로그인</button>
		
		</form>
		
	</c:if>
	<!-- 비어있지않으면 -> 반갑습니다, 하고 로그 아웃 버튼  -->
		<c:if test="${not empty loginUser }">
		<p> ${loginUser } 반갑습니다.</p>
		<a href = "/logout">로그아웃</a>
	
	
	</c:if>
	



	<h2>여기는 hello jsp입니다.</h2>

</body>
</html>