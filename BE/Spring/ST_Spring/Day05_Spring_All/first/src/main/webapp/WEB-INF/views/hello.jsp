<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri = "jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>helloJsp</title>
</head>
<body>
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
	
	<c:if test="${not empty loginUser }">
	<!-- 로그인 정보가 있다면 -->
		<p> ${loginUser } 님 반갑습니다.</p>
		<a href="/logout">로그아웃</a>
		<br>
		<a href="regist">등록화면으로 이동</a>
	</c:if>
	
	
	
	
	
	
	

</body>
</html>