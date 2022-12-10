<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invalidate</title>
</head>
<body>
	<h1>session attribute값 부분 제거 vs invalidate(전체 무효화)</h1>
	<%
		// session attribute에 데이터저장
		session.setAttribute("password", 123);
		
		// session attribute 출력
		Enumeration<String> attrNames = session.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			String name = attrNames.nextElement();
			// session.removeAttribute(name); // userid 속성 제거랑 같은 결과
			out.println(name + "<br>");	
		}
		
		//  타입 2
		out.println("<p>userid 속성이 아래에서 제거 될구야</p><br>");
		session.removeAttribute("userid");	
		attrNames = session.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			String name = attrNames.nextElement();
			out.println(name + "<br>");		
		}
		
		session.invalidate(); // 세션 무효화 : 모든 세션 속성 제거
		// 유효하지 않은 세션 : 세션 속성이 아무것도 없거나 세션이 invalidate된 경우
		
		
		// 현재 세션이 유효(valid)한지 체크
		if(request.isRequestedSessionIdValid()) {
			out.println("유효한 세션<br>");
		} else {
			out.println("유효하지 않은 세션<br>");
		}
		
	%>
		
</body>
</html>