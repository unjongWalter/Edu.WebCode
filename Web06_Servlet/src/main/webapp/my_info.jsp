<%@page import="edu.web.servlet05.InfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_info</title>
</head>
<body>

	<%
		String name = (String) request.getAttribute("name"); // 넣고 형, 꺼내도 형
		String lived = (String) request.getAttribute("lived");
		int age = (Integer) request.getAttribute("age");
		InfoVO vo = (InfoVO) request.getAttribute("vo");
	%>

	<h1>결과 페이지</h1>
	<p>이름은<%=name %>이다.</p>
	<p>나이는<%=age %>일걸.</p>
	<p>사는 곳은<%=lived %>Des.</p>
	<p>vo : <%=vo %></p>
	
</body>
</html>