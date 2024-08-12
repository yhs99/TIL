<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본태그 - scriptlet</title>
</head>
<body>
	<%
		// 스크립트릿에서 선언된 변수는 _jspService()메서드의 지역변수로 만들어 진다.
		int num1 = 3, num2 = 5;
		int result = num1 + num2;
		out.print("<div>" + num1 + " + " + num2 + " = "		 + result + "</div>");
	%>
	
	<%!
		//선언문에서 선언된 변수나 메서드들은 jsp 페이지가 초기화 될 때 초기화되어서 (멤버변수, 멤버메서드)
		// 페이지 내의 어떠한 스크립트릿이나 표현식에서도 접근해서 사용할 수 있다.
		
		String str = "안녕하세요.";
	
		public int abs(int n) {
			if(n < 0) {
				n = -n;
			}
			return n;
		}
	%>
	
	<%= str %>

	<%= abs(-4) %>
</body>
</html>