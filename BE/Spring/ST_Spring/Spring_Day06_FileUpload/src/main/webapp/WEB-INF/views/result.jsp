<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>

	${filename }이 등록되었습니다.
	<a href="/img/${filename}">사진 보기</a>
	
	<!-- 파일 식별자가 fileName -->
	<a href="/download?fileName=${filename }">이미지다운로드</a>
	
	<img src="/img/${filename }">
	<!-- 알림창이 뜨는 이유 : 포워드 방식으로 데이터가 들어있는데 그것을 그대로 다시 반복이 맞는지 확인 -->

</body>
</html>