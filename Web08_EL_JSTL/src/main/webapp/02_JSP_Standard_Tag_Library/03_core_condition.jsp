<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL If</title>
</head>
<body>
	<%--
		* <c:if> tag
		- java if문과 유사
		- <c:if test="조건">실행문</c:if>	
	 --%>
		
	<c:if test="true">
		<h2>항시발동</h2>
	</c:if>
	
	<c:if test="false">
		<h2>노 항시발동</h2>
	</c:if>
		
	<c:if test="${param.name == 'test' }">
		<p>결과 값 true</p>
		<p>파라미터 name 값은 'test'</p>
	</c:if>
	<%-- url에 name=test를 타이핑하면 답출력됨... --%>
	
	<%--
	* <c:choose> 태그
	- 자바의 switch문과 if-else문 섞음	
	 --%>
	
	<ul>
		<c:choose>
		<!--  parameter string return, attr =object retrun -->
			<c:when test="${param.flag == 0 }">
				<li> param flag 값은 0</li>
			
			</c:when>
			
			<c:when test="${param.flag == 1 }">
			<li> param flag 값은 1</li>
			
			</c:when>
			
			<c:when test="${param.flag == 2 }">
			<li> param flag 값은 2</li>
			
			</c:when>
			
			<c:otherwise>
				<li>param flag 0, 1, 2 중에 입력 ㄱ</li>
			
			</c:otherwise>
			
		</c:choose>
	</ul>
	
</body>
</html>