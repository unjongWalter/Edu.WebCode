<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Form 1번</title>
</head>
<body>
	<%
	// TODO : <a> 태그를 이용하여 member-register.jsp 이동 링크 생성
	// TODO : 회원가입 form 생성. action="login_auth.do" method="post"
	// 잘못된 접근 
	String wrongApproach = (String) request.getAttribute("wrongApproach");
	if(wrongApproach != null) {
		out.print("<script>alert('잘못된 접근');</script>");
		return;
	}
	
	%>
	
	<h1>로그인하쟈</h1>
	<form action="login_auth.do" method="post">	
	아디 : <input type="text" name="userid" required="required"><br>
	비번 : <input type="password" name="password" required="required"><br>	
	<br><input type="submit" value="로그인">
	</form>
	
	<a href="member-register.jsp"><input type="button" value="회원가입"></a>
	
</body>
</html>