<%@page import="java.util.Set"%>
<%@page import="com.jspbasic.dto.ProductDTO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>application 영역에서 바인딩한 객체 읽어오기</h1>
	<%
		Map<String, ProductDTO> phoneMap = (Map<String, ProductDTO>) application.getAttribute("phones");
	
		Set<String> keys = phoneMap.keySet();
		for(String key : keys) {
			ProductDTO product = phoneMap.get(key);
		}
	%>
</body>
</html>