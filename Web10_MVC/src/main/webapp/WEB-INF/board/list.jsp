<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
border-style : solid;
border-width : 1px;
text-align : center;
}

ul {
list-style-type : none;
}

li {
display : inline-block;
}

</style>
<meta charset="UTF-8">
<title>Board Main Page. list.jsp</title>
</head>
<body>
	<h1>Board Main</h1>
	
	<c:if test="${empty sessionScope.memberId }">
		<a href="login.go">login</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.memberId }">
		<p>${sessionScope.memberId }놈아 왔나?</p>
		<a href="logout.go">logout</a>
	</c:if>
	
		<br>	
	<a href="register.do"><input type="button" value="write"></a>
		<br>
		
	<table>
		<thead>
			<tr>
				<th style="width: 60px">number</th>
				<th style="width: 700px">title</th>
				<th style="width: 120px">writer</th>
				<th style="width: 100px">enroll date</th>			
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.boardId }</td>
					<!-- boardTitle, boardId로 접근하자. -->
					<td><a href="detail.do?boardId=${vo.boardId }">${vo.boardTitle }</a></td>
					<td>${vo.memberId }</td>
					<td>${vo.boardDateCreated }</td>
				</tr>						
			</c:forEach>		
		</tbody>		
	</table>
	
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="list.do?page=${pageMaker.startPageNo - 1 }">Prev</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }" var="num">
			<li><a href="list.do?page=${num }">${num }</a></li>		
		</c:forEach>
		
		<c:if test="${pageMaker.hasNext }">
			<li><a href="list.do?page=${pageMaker.endPageNo + 1 }">Next</a></li>
		</c:if>
	</ul>
		
</body>
</html>