<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삼각형의 넓이 구하기 및 유저정보</title>
</head>
<body>
<form action="actionSvl" method="get">
밑변 :<input type="text" name="side">
높이 : <input type="text" name="height">
<input type="submit">
</form>
<hr>

<form action="actionSvl" method="post">
이름 : <input type="text" name="name">
아이디 : <input type="text" name="id">
비밀번호 : <input type="password" name="password">
<input type="submit">
</form>
</body>
</html>