
<%@page import="edu.web.jspl01.ContactVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach</title>
</head>
<body>
	<%--
	* <c:forEach> tag
	- for, for-each
	- 배열 컬렉션, 맵 등에 저장되어 있는 값을 순차적으로 처리
	- 기본 형태
	<c:forEach var="변수" items="아이템" begin="시작값" end="끝값" step="증가값">
	${변수}
	</c:forEach>
	- items : array, collection, map 형태 데이터 저장
	- begin(생략 가능) : 시작 인덱스
	- end(생략 가능) : 끝
	- step(생략) : 증감
	- 주의) Iterator, Enumeration, Map의 경우 데이터 저장 순서와 읽는순서가 
	일치하지 않을 수 있기에 begin, end, step 속성을 잘 사용 ㄴㄴ	
	 --%>

	<h2>1~100 홀수의 합</h2>
	<c:set var="sum" value="0"/>
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum + i }"/>
	</c:forEach>
	<p>sum : ${sum }</p>

	<h2>구구단</h2>

	<c:forEach var="i" begin="2" end="9">
		<c:forEach var="j" begin="1" end="9">
		${i} * ${ j } = ${i*j }<br>
		</c:forEach>
	</c:forEach>
	
	<%
	String[] sports = {"야구", "축구", "스쿼시", "테니스"};	
	request.setAttribute("sports", sports);	
		
	%>
	<!-- for(String s : sports) {
	syso(s);
	}
	 -->
	<h2>배열 데이터 출력</h2>
	<c:forEach var="s" items="${sports }" varStatus="status">
	현재 인덱스 값 : ${status.index }<br>
	문자열 값 : ${s }<br>
	루프 실행 횟수 : ${status.count }<br>
		begin 값 : ${status.begin }<br>
		end 값 : ${status.end }<br>
		step 값 : ${status.step }<br>
	
	</c:forEach>
		
		<%
			ArrayList<ContactVO> list = new ArrayList<>();
			ContactVO vo = null;
		
			for(int i = 0; i < 5; i++){
				String name = "학상"+ (i+1);
				String phone = "010-1111-2222" + (i+1);
				String email = "test" + (i+1) + "@test.com";
				vo = new ContactVO(name, phone, email);
				list.add(vo);				
			}		
			request.setAttribute("list", list);	
		%>
		
		<c:forEach var="vo" items="${list }">
			<p>name : ${vo.name }</p> <!-- getName으로 private를 뚫어서 가져온다. 단순 변수불러오기 ㄴㄴ -->
			<p>phone : ${vo.phone }</p>
			<p>email : ${vo.email }</p>
						
		</c:forEach>
						
</body>
</html>