<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result</title>
</head>
<body>
	<!-- 	
	3. 로그인 결과 jsp 생성(HW4_login_result.jsp)
	- 세션에서 id값을 꺼내서 출력
	- 만약 url로 직접 접속할 경우 '로그인 해라'라고 alert를 띄우고
	  HW4.jsp 페이지로 이동	
	  -> out.print("<script>alert('로긴 ㄱ');</script>");	
	 -->

	<%
	String useridHW = (String) session.getAttribute("useridHW");
//	String passwordHW = (String) session.getAttribute("passwordHW");
	%>

	<%
	if (useridHW == null) {
		out.print("<script>alert('로그인 안하냐... 이동시켜줄게...');</script>");
		out.print("<script>location.href='HW4.jsp'</script>");
	} else {
	
	}
	%>
	
	<h1>로그인 당한 상황</h1>
	<h2><%=useridHW%>님, 환영해줘? 말어?</h2>
	
</body>
</html>