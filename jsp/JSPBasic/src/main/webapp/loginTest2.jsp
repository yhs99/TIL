<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<c:choose>
	<c:when test="${!sessionScope.isLogined}">
		<form action="SessionLoginServlet" method="POST">
			<div>아이디 : <input type="text" name="id"></div>
			<div>패스워드 : <input type="password" name="password"></div>
			<div>
				<p> ${msg}</p>
			</div>
			<div>
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</div>
		</form>
	</c:when>
	<c:when test="${sessionScope.isLogined}">
		<c:redirect url="mainTest.jsp"></c:redirect>
	</c:when>
</c:choose>
</body>
</html>