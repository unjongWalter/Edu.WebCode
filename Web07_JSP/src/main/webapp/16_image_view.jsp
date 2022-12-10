<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show the Images</title>
</head>
<body>
	<%
	String fileName = (String) session.getAttribute("fileName");
	%>

	<img alt="질럿" src="images/<%=fileName %>" width="200" height="300">

</body>
</html>