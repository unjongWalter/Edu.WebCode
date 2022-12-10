<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산기</title>
</head>
<body>
	<h1>적금 계산기</h1>
	<!-- 
	JSP 파일 생성(적금 계산 결과 페이지)
	1. 월 적금액, 기간, 이자율을 전송하는 form 만들기(HW1.jsp)
	- <form action="HW1_result.jsp" method="get">
	2. 월 적금액, 기간, 이자율을 전송받아 계산하여 출력하는 jsp 만들기(HW1_result.jsp)	
	parameter : client(form) -> server (o)
				server -> client (x) (forward랑 헷갈리겠다...)
				set이 없음.
	attribute : server -> client (o), 서버에서 뭔가 받아오는건 전부~
	 -->
	
	<form action="HW1_result.jsp" method="get">
		<input type="number" name="inputMoney" placeholder="월 납입금"><br>
		<input type="number" name="period" placeholder="기간"><br>
		<input type="text" name="interest" placeholder="이자율"><br>		
		<button type="submit">계산</button>
	</form>

</body>
</html>