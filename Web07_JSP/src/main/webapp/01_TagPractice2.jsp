<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TagPractice2</title>
</head>
<body>
	<%
		ArrayList<String> list = new ArrayList<>(); // new 잘안함
		list.add("Dolby");
		list.add("Doldy");
		list.add("Bolby");
		list.add("Boldy");	
	%>


	<ul>
		<li>Doooooli's Fam</li>
		<li><%=list.get(0) %></li>
		<li><%=list.get(1) %></li>
		<li><%=list.get(2) %></li>
		<li><%=list.get(3) %></li>
	</ul>


	<%
		list.remove(0);	
	%>


	<ul>
		<li>Doooooli's Fam's Fam</li>
		<li><%=list.get(0) %></li>
		<li><%=list.get(1) %></li>
		<li><%=list.get(2) %></li>			
	</ul>

</body>
</html>