<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="04_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>Directive로 에러페이지 처리</h1>
	<p>나눗셈 결과 : <%=123/1 %></p>

	<%
		String[] str = new String[2];
		str[5] = "aloha";
	%>
</body>
</html>