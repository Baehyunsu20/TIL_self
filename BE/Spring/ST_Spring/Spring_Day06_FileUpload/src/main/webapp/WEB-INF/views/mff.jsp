<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Single File Form</title>
</head>
<body>
	<h2>다중파일업로드</h2>
	<form action="Multiup" method="POST" enctype="multipart/form-data">
<!-- 		<label>파일 입력</label> -->
		<input type="file" name="files" multiple="multiple">
		<button>파일등록</button>
	</form>

</body>
</html>