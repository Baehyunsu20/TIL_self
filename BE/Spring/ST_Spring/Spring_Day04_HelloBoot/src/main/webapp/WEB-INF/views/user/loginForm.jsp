<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
	<h2>로그인</h2>
	<!-- 폼태그에는 2가지 속성 -> action(슬래쉬가 들어가냐마냐), method = POST, GET  -->
	<!-- action 및 경로의 대소문자 구분 잘 하기 -->
	<form action="/login" method = "POST">
		ID : <input type = "text" name="id">
		PW : <input type = "password" name="pw">
		<!-- input type = sumbit과 같은 속성을 가지는 button -->
		<button>로그인</button>
	</form>

</body>
</html>