<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>왜 Servlet</title>
<script>
	function hello() {
		alert("!");
	}
</script>
<style>
	h1 {
		color:red;
		background-color: lime;
	}
</style>
</head>
<body>
	<h1 onclick="hello();">왜 Servlet</h1>
	
	<%!
		int num = 4;
		String output = "";
		String color ="";
	%>
	<%
		if(num % 2 == 0) {
			color = "red";
			output = "짝수 입니다.";
		}else {
			color = "blue";
			output = "홀수 입니다.";
		}
	%>
	<div style="color: <%= color %>">
		<%= output %>
		
	</div>
	
<form action="./HelloServlet" method="get">
	<input type="text" name="name">
	<button type="submit">요청</button>
</form>
<form action="./HelloServlet" method="post">
	<input type="text" name="name">
	<button type="submit">요청</button>
</form>
</body>
</html>