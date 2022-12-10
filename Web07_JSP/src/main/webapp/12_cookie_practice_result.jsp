<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Practice Result</title>
	
	<%
	request.setCharacterEncoding("UTF-8");
	
	String agreed = request.getParameter("isSaveAgreed"); // dt 꺼내기 우선
	// 체크박스가 선택된 경우 agreed가 저장되어 있음
	if(agreed != null){ // id저장이 체크된 경우
		Cookie idd = new Cookie("idd", request.getParameter("idd"));
		Cookie pw = new Cookie("pw", request.getParameter("pw"));
		
	idd.setMaxAge(900);
	pw.setMaxAge(900);
	response.addCookie(idd);
	response.addCookie(pw);
	}
	// when you use cookie, dont forget to use response.add~
	%>

</head>
<body>
	<h1>Login Result</h1>
	<h2>씨발 로그인 쳐봐라 개짱나네</h2>
	<p><%=request.getParameter("idd") %>, 야 그냥 로그인 쳐해라</p>
	<p><%=request.getParameter("pw") %></p>
		
</body>
</html>