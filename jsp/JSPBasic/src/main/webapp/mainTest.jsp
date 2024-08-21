<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${!sessionScope.isLogined}">
		<c:redirect url="loginTest2.jsp"></c:redirect>
	</c:when>
	<c:when test="${sessionScope.isLogined}">
		<div>로그인 유저 : <%= session.getAttribute("loginMemberId") %></div>
		<div>
			<form action="SessionLoginServlet" method="GET">
				<input type="submit" value="로그아웃">
			</form>
		</div>
	</c:when>
</c:choose>
</body>
</html>