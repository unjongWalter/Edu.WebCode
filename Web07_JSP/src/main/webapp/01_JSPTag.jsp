<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Tag</title>
</head>
<body>
<!-- 
	* JSP(Java Server Page)
	- HTML 파일 안에 자바 코드를 포함하여 웹서버에서 동적으로
	웹 페이지를 생성하여 브라우저로 리턴해주는 언어
	- 런타임 시에 JSP 파일(.jsp)이 자바 파일(.java)로 변환됨 -> 서블릿 클라스
	- HTML 표준을 지키기 때문에 디자인이 편함
 -->

<%--
 * JSP 구성 요소
1. <%@ %> : Directive(지시자)
 - JSP 페이지 전체에 적용하는 속성들을 설정(import, page, charEncoding 등)
2. <%! %> : Declaration(선언문)
- 멤버 변수, 메소드, 내부 클래스를 선언하는 부분
3. <% %> : Scriptlet(스크립틀릿) 중요, 서블릿의 서비스랑 동일(리퀘스트, 리스폰스)
- 메소드(_jspService) 내부에서 실행되는 자바 코드를 작성하는 부분(doPost 유사)
4. <%= %> : Expression(표현식)
- 변수의 값, 메소드의 리턴 값 등을 HTML에 출력
5. Comment(주석)
- JSP 주석은 서블릿 클래스로 변환될 때 코드로 변환되지 않음(읽지 못함)
--%>

	<%-- Declaration(선언문) --%>
	<%!	
		public int add(int x, int y) {
			return x + y;
	}	
	%>

	<%-- Scriptlet --%>
	<%
	
		// 지역 변수 선언
		int result = add(20, 30);
	
		// JSP에서 출력 방법
		// 1) console 로그
		System.out.println("result = " + result);
	
		// 2) JspWriter 객체를 사용하여 응답(response)으로 출력, 해지마~
		out.write("<p>result = " + result + "</p>\r\n");

		// 3) Expression 사용

	%>

	<%-- Expression --%>
	<p>결과 = <%=result %></p>
	
	<%
		Date date = new Date();		
	%>
	
	<p><%=date %></p>
	

</body>
</html>