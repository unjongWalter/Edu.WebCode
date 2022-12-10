<%@page import="edu.web.member.MemberVO"%>
<%@page import="org.apache.catalina.manager.util.SessionUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info</title>
<script type="text/javascript">
alert("Let me Show You Some!")
</script>

</head>
<body>

	<%
	String userid = (String) session.getAttribute("userid");
	if(userid == null){
		out.print("<script>alert('세션만료');</script>");
		out.print("<script>location.href='login.jsp'</script>");
		return;
	}
		
	%>
		
	<%
	// TODO : 회원 정보 출력
	// TODO : 회원 수정 버튼 생성, jsp 페이지에 userid 전송
	// TODO : 회원 탈퇴 버튼 생성
	// 세션 릴레이, 넣을때 Attri 한만큼 같이해
	MemberVO vo = (MemberVO) request.getAttribute("vo");
	%>

	<h1><%=userid%>니마, 보여주까 마까?</h1>
	
	아디 : <p><%=vo.getUserid()%></p>
	<br> 
	비번 : <p><%=vo.getPassword()%></p>
	<br> 
	이멜 : <p><%=vo.getEmail()%></p>
	<br> 
	이멜수신 여부 : <p><%=vo.getEmailAgree()%></p>
	<br> 
	관심사 : 	<p><%=vo.getInterestJoin()%></p>
	<br> 
	핸폰 : <P><%=vo.getPhone()%></P>	
	<br> 
	<p>소개 : </p>
	<%=vo.getIntroduce()%><br>

	<!-- jsp -> sevlet -> jsp로 이동이 정상이다. 지금은 학습용으로 놀고있네 -->
	<a href="member-update.jsp?userid=<%=userid%>"><input type="button"
		value="정보수정"></a>
	<a href="delete.do?userid=<%=userid%>"><input type="button"
		value="회원탈퇴"></a>

</body>
</html>