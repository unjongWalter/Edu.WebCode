<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>

	<%
	// request : forward에서 넘겨받은 request 객체	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	int money = Integer.parseInt(request.getParameter("money"));	
	request.setCharacterEncoding("UTF-8");
	%>
	
	<h1>결과 페이지</h1>
	<p>이름은<%=name %>이다.</p>
	<p>나이는<%=age %>일걸.</p>
	<p>email<%=email %>Des.</p>
	<p>money<%=money %>억 이Rao.</p>
</body>
</html>