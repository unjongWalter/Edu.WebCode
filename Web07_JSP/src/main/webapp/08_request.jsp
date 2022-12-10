<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Request 받는놈</title>
</head>
<body>
	<h1>니정보 ㅋ</h1>
	<%	
		out.println("니 아이피 : " + request.getRemoteAddr() + "<br>");
		out.println("니 호스트이름 : " + request.getHeader("host") + "<br>");
		out.println("니 쿠키 : " + request.getHeader("cookie") + "<br>");
		out.println("니 서블릿 경로 : " + request.getServletPath() + "<br>");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
				
	%>

	<h1>결과 페이지</h1>
	<p>난 말야... <%=firstName + lastName %> Rao.</p>
	
	
</body>
</html>