<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	font-family : arial, sans-serif;
	border-collapse : collapse;
	width : 100%;
}

td, th {
	border : 1px solid #dddddd;
	text-align : left;	
	padding : 8px;
}

</style>

<meta charset="UTF-8">
<title>JSP Syntax Practice 2</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전번</th>
				<th>이멜</th>
			</tr>
		</thead>
		
		<tbody>
		<%for(int i = 0; i < 2; i++){ %>
			<tr>
				<td>test<%=i+1 %></td>
				<td>010-<%=i %></td>
				<td><%=i %>@test.com</td>			
			</tr>			
			
		<%}	%>		
		
		</tbody>
		
	</table>

</body>
</html>