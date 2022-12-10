<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Practice Input</title>
<%
Cookie[] loginCookies = request.getCookies(); // 쿠키인지 나발인지 쳐꺼내라
String idd = "";
String pw = "";

if (loginCookies != null) { // 쿠키 존재 시
	for (Cookie loginCookie : loginCookies) {
		if (loginCookie.getName().equals("idd")) {
	idd = loginCookie.getValue();
		} else if (loginCookie.getName().equals("pw")) {
	pw = loginCookie.getValue();
		}
	}
}

//		out.print("idd1 : " + loginCookie.getValue() + "<br>");				
//		out.print("pw1 : " + loginCookie.getValue() + "<br>");
%>

</head>
<body>
	<form action="12_cookie_practice_result.jsp" method="post">
	아이디 <br> <input type="text" name="idd" placeholder="아이디 입력" value="<%=idd%>"><br>
	비밀번호 <br> <input type="password" name="pw" placeholder="비밀번호 입력" value="<%=pw%>"><br>
	<input type="checkbox" name="isSaveAgreed" value="agreed"> 아이디저장<br>
	<br> <input type="submit" value="로그인">
	</form>

</body>
</html>
