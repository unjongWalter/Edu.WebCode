<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!// !는 public class Test {} 느낌~
	// 멤버 변수, 전역 변수
	int fontSize;
	int day = 7;
	%>

<html>
<head>
<meta charset="UTF-8">
<title>JSP Syntax</title>
</head>
<body>
	<%
	// servlet의 service 영역과 유사... request 선언 가능스
	int test = 7; // 지역 변수
	%>


	<%
	if (day == 1 || day == 7) {
	%>


	<p>주말 당하셨씁네까?</p>


	<%
	} else {
	%>


	<p>평일 당하였나봅니다.</p>
	<%
	System.out.println("항시발동 확인용");
	%>

	<%
	}
	%>

	<%--
		JSP 태그는 HTML 내 어느 위치에서든 사용 가능
	 --%>

	<%
	for (fontSize = 5; fontSize <= 7; fontSize++) {
	%>
	<font color="green" size="<%=fontSize%>">Practice JSP Syntax</font>
	<br>

	<%
	}
	%>


</body>
</html>