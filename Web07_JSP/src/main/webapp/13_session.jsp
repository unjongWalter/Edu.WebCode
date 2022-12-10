<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
<%
	// session 객체 : session 범위에 존재하는 객체
	
	// session 생성 시간
	Date createTime = new Date(session.getCreationTime());
	
	// 이 웹페이지의 마지막 접속 시간
	Date lastAccessTime = new Date(session.getLastAccessedTime());
		
	// session inactive time set1
	session.setMaxInactiveInterval(600000000);	// 60 + a sec
	
	// session inactive time set2
	// - web.xml 설정
	
	/* 
	<session-config>
	<session-timeout>10</session-timeout> // 분 단위
	</session-config>		
	*/
	
	// 세션에 키값 저장하기 키밸류타입
	session.setAttribute("userid", "운영자");
//	session.setAttribute("password???", "비밀");
%>

</head>
<body>

	<%--
	* HTTP 특성
	- connectionless : 클라이언트가 요청을 한 후 응답을 받으면 연결을 끊는 특성
	- stateless : 통신이 끝나면 상태를 유지하지 않는 특성
	- 쿠키와 세션은 HTTP 특성이 아닌 연결 상태를 유지하기 위해 사용

	* 세션
	- 쿠키를 기반으로 사용
	- 서버 측에서 데이터를 관리
	- 세션 ID를 부여하여 브라우저를 종료할 때까지 데이터를 유지
	- 세션 객체 : 사용자를 식별할 수 있는 방법 제공
	1) 특정 페이지 요청
	2) 웹 사이트 방문 카운트
	3) 사용자에 대한 정보 저장
	- 주의사항 : 세션은 현재 프로젝트(클라이언트)에 실행되는 모든 웹페이지에 적용딤
	따라서, 하나의 클라이언트에 세션을 많이 사용하면 충돌이 발생 가능
	- session 객체는 세션의 메소드를 사용하면 생성됨(ex. session.setAttribute())
 	--%>

	<h2>session id : <%=session.getId() %></h2>
	
	<h2>session create time : <%=createTime %></h2>
	<h2>last access time : <%=lastAccessTime %></h2>
	<a href="13_session_test.jsp">13_session_test.jsp 페이지 이동시켜드림.</a>
	
</body>
</html>