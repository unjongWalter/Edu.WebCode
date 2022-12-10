<%@page import="edu.web.homework.ContactVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW2 또...</title>
</head>
<body>
	<!-- 
	1. 이름, 연락처, 이메일 변수로 갖는 ContactVO.java 생성
	(위치 : src/edu.web.homework/ContactVO.java)
	2. HW2.jsp 파일
	- ArrayList<ContactVO>를 선언하고 객체 생성
	- 임의로 3~5개의 데이터를 생성하여 ArrayList에 모두 저장
	- ArrayList에 저장된 데이터를 반복문과 <table> 태그를 이용하여 출력
	서버사이드에서 입력된 것 뿌리는 역할
	-->

	<%
	ArrayList<ContactVO> list= new ArrayList<>();
	ContactVO vo = new ContactVO("백", "010-1111-2222", "t@test.com");
	list.add(vo);
	
	list.add(new ContactVO("복","010-1111-2222", "t@test.com"));
	list.add(new ContactVO("뵥","010-1111-2222", "t@test.com"));
	list.add(new ContactVO("목","010-1111-2222", "t@test.com"));
	list.add(new ContactVO("묙","010-1111-2222", "t@test.com"));
	%>

	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전번</th>
				<th>이멜</th>
			</tr>
		</thead>
		
		<tbody>
		<%for(int i = 0; i < list.size(); i++){ %>
			<tr>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getPhone() %></td>
				<td><%=list.get(i).getEmail() %></td>			
			</tr>

		<%
		}
		%>
		
		</tbody>
	</table>
	
</body>
</html>