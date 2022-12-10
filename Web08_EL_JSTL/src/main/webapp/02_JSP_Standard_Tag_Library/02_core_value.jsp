<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
	<h2>JSTL Core practice</h2>
	<c:set var="name1" value="Dow"></c:set>
	<p>name1's value : ${name1 }</p>
	<c:set var="name2" value="${name1 }"/>
	<p>name2's value : ${name2 }</p>

	<%--
		<c:remove> 태그
		- set 태그로 지정한 변수를 삭제할 때 사용
		- scope 영역을 지정하지 않으면 동일한 이름의 변수를 모두 삭제(주의)
		
	 --%>
	 <c:remove var="name1"/>
	 <p>name1's value : ${name1 }</p>


</body>
</html>