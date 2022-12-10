<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>^^회원가입^^</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); // 한글인코딩 %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	<jsp:setProperty property="*" name="member" />
	
	<%
	String interest = null;
	
	if(member.getInterest() == null) {
		interest = "";
	} else {
		interest = String.join(", ", member.getInterest());	
		// String.join() : 배열의 데이터를 특정 구분문자를 포함하여 연결
	}
	%>
	
	<h1>회원 가입 결과 봐봐라...</h1>
	<p>아디 : <%=member.getUserid() %></p>
	<p>비번 : <%=member.getPassword() %></p>
	<p>이멜 : <%=member.getEmail() %></p>
	<p>이멜 수신여부 : <%=member.getEmailAgree() %></p>
	<p>관심사 : <%=interest %></p>	
	<p>핸폰 : <%=member.getPhone() %></p>
	<p>소개 : <%=member.getIntroduce() %></p>

</body>
</html>