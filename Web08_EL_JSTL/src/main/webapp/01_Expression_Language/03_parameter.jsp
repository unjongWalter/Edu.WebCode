<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Member's Info~/Receiver</title>
</head>
<body>
	<!-- param.(파라미터이름) == request.getParameter(파라미터이름) -->
	<p>id : ${param.userid }</p>
	<p>pw : ${param.password }</p>
	<p>email : ${param.email }</p>
	<p>emailAgree : ${param.emailAgree }</p>
	<p>interest : </p>
	<p>${paramValues.interest[0] }</p>
	<p>${paramValues.interest[1] }</p>
	<p>${paramValues.interest[2] }</p>
	<p>${paramValues.interest[3] }</p>
	<p>${paramValues.interest[4] }</p>
	
	<p>phone : ${param.phone }</p>
	<p>introduce : ${param.introduce }</p>
	
</body>
</html>