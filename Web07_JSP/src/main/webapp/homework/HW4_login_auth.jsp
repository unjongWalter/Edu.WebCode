<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Auth</title>
</head>
<body>
	<!-- 
	2. 로그인 인증 jsp 생성(HW4_login_auth.jsp)
	- 전송받은 id, pw를 확인하여 id=="test", pw="1234"일 경우
	  id, pw 세션을 생성(만료 시간 자유)
	  세션을 생성한 이후에 HW4_login_result.jsp 페이지로 이동
	  -> out.print("<script>location.href='HW4_login_result.jsp'</script>");
	  - 전송받은 id, pw가 불일치 시, HW4.jsp 페이지로 이동	
	 -->

	<%
	// HW4에서의 값 꺼내기!
	String useridHW = request.getParameter("useridHW");
	String passwordHW = request.getParameter("passwordHW");
	
	if (useridHW.equals("test") && passwordHW.equals("1234")) {
		
		// session attribute에 데이터저장
		session.setAttribute("useridHW", "test");
		session.setAttribute("passwordHW", "1234");
		
		session.setMaxInactiveInterval(600000000);
		out.print("<script>alert('로그인 굳굳')</script>");
		out.print("<script>location.href='HW4_login_result.jsp'</script>");
	} else {
		out.print("<script>alert('이러지말자...')</script>");
		out.print("<script>location.href='HW4.jsp'</script>");	 
	 }
		
	%>
</body>
</html>