<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW1 결과 페이지</title>
</head>
<body>
<%
int inputMoney = Integer.parseInt(request.getParameter("inputMoney"));
int period = Integer.parseInt(request.getParameter("period"));
double interest = Double.parseDouble(request.getParameter("interest"));
// 변수명은 일치가 기본.
int totalInputMoney = inputMoney * period;
double totalInterest = totalInputMoney * interest / 100;
double totalReceiveMoney = totalInterest + totalInputMoney;

DecimalFormat df = new DecimalFormat("￦,###,###,###,###");
// 
%>

<h1>적금 계산</h1>
	<h2>입력받은 정보</h2>	
	<p>월 금액(원) : <%=df.format(inputMoney) %></p>
	<p>적금 기간(월) : <%=period %></p>
	<p>년 이자(%) : <%=interest %></p>
	<hr>
	<h3>계산 결과</h3>
	<p>총 납입 금액(원) : <%=df.format(totalInputMoney) %></p>
	<p>발생 이자(원) : <%=df.format(totalInterest) %></p>
	<p>총 수령액(납입금+이자환산액, 원) : <%=df.format(totalReceiveMoney) %></p>

</body>
</html>