<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="useBean.jsp" method="POST">
	<div>아이디 : <input type="text" name="userId"></div>
	<div>패스워드 : <input type="password" name="pwd"></div>
	<div>이메일 : <input type="email" name="email"></div>
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</div>
</form>
</body>
</html>