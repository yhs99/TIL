<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - useBean</title>
</head>
<body>
	<jsp:useBean id="member" class="com.jspbasic.dto.MemberDTO"/>
<%-- 	<jsp:setProperty property="userId" name="member" value="abc"/>
	<jsp:setProperty property="pwd" name="member" value="1234"/>
	<jsp:setProperty property="email" name="member" value="abc@gmail.com"/> --%>
	<jsp:setProperty property="*" name="member"/>
	
	<%= member.getUserId() %> <br>
	<%= member.getPwd() %> <br>
	<%= member.getEmail() %>
</body>
</html>