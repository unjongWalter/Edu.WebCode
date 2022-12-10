<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과 페이지</title>
</head>
<body>
	<%
		MemberVO vo = (MemberVO) request.getAttribute("vo");
	
	%>


	<h1>특별히 보여준다 내가...</h1>
	<p><%=vo.getUserid() %>야, 반갑데이</p>
	
	<p>id : <%=request.getParameter("userid") %></p>
	
</body>
</html>