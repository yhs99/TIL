<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("id")!=null) {
		Enumeration<String> em = session.getAttributeNames();
		String names = "";
		String values = "";
		while(em.hasMoreElements()) {
			names = em.nextElement();
			out.print("속성 이름 : " + names + ", ");
			values = (String) session.getAttribute(names);
			out.print("속성 값 : "+values + "<br>");
		}
%>
	<%= session.getAttribute("id") %> 로그인
<% 
	}else {
%>
	로그인 실패
<%
	}
%>
</body>
</html>