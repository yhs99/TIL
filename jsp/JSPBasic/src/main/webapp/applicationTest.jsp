<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jspbasic.dto.ProductDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>application 영역</h1>
	<%
		Map<String, ProductDTO> maps = new HashMap<>();
		maps.put("galaxy", new ProductDTO("갤럭시", 1, 1000, "블루"));
		maps.put("iPhone", new ProductDTO("아이폰", 1, 1500, "화이트"));
		application.setAttribute("phones", maps);
	%>
	<div><a href="appPage.jsp">appPage.jsp</a></div>
</body>
</html>