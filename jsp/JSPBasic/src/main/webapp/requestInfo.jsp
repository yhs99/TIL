<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>context path : <%= request.getContextPath() %></li>
		<li>요청방식 : <%= request.getMethod() %></li>
		<li>요청 URL : <%= request.getRequestURL() %></li>
		<li>요청 URI : <%= request.getRequestURI() %></li>
		<li>쿼리스트링 : <%= request.getQueryString() %></li>
		<li>요청프로토콜 : <%= request.getProtocol() %></li>
		<li>요청 클라이언트 주소 : <%= request.getRemoteAddr() %></li>
		<li>요청 파일의 실제 경로 : <%= request.getRealPath("requestInfo.jsp") %></li>
		
	</ul>
</body>
</html>