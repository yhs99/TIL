<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int globalCnt = 0; %>
	<%
		System.out.println(session.toString());
		int localCnt =0;
		out.print("<br> local : ");
		out.print(++localCnt);
		out.print("<br> global : ");
		out.print(++globalCnt);
		
	%>
</body>
</html>