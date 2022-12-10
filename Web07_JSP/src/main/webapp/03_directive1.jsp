<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive 1</title>
</head>
<body>
	<%--
	* Directive(지시자)
	- 기본 타입
		<%@ directive attribute="value" %>
		- directive 이름
		<%@ page .. %>
		<%@ include .. %>
		<%@ taglib .. %>
		- 속성(attribute) 종류
		contentType
		errorPage
		extends
		import 등	
	 --%>

	<%--header.jspf 파일을 include --%>
	<%@ include file="03_header.jspf" %>
	<h1>include directive(지시자)</h1>
	
	<div>
		<p>본문 first</p>
		<p><%=headerK %></p><%-- 03>header.jspf 변수를 사용 가능 --%>
		<p>who's the next?</p>
	</div>
	<%--
	* directive include 특징
	1. JSP 파일이 자바 파일로 바뀔 때 문서에 삽입되어 컴파일(정적)
	2. 다수의 JSP 페이지에서 공통으로 사용되는 코드를 작성하는 용도
	3. 중요) include를 적용한 jsp 파일에서 선언된 변수들을, jsp 파일에서 ~
	--%>
	
	<%@ include file="03_footer.jspf" %>
	
	<div>
		<p>본문 again</p>
		<p><%=footerK %></p><%-- 03>footer.jspf 변수를 사용 가능 --%>
		<p>who's the next?!!!!!!!!!!!!!!!</p>
	</div>
			
</body>
</html>