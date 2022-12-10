<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Cookie!</title>
</head>
<body>
	<h1>Get Cookie!</h1>
	<%
		// 이 도메인(어플리케이션)과 관련있는 쿠키의 값들(배열) 가져오기
		Cookie[] cookies = request.getCookies();
	
		if(cookies != null) { // 쿠키 존재 시
			out.println("<h2> cookies for u! </h2>");
			Cookie cookie = null;
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("name1 : " + cookie.getName() + "<br>");
				out.print("value1 : " + cookie.getValue() + "<br>");
				
			}
		} else { // 쿠키 미존재 시
			out.println("<h2> there are no cookies! </h2>");
		}
	
	%>


</body>
</html>