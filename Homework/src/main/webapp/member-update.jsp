<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>

</head>
<body>
	<%
	// TODO : 세션 검사코드 // 세션 제거 removeAtt
	// TODO : 회원가입 폼과 유사. userid는 변경 불가 input 태그 설정.(아이디 변경 불가 구현 찾아봐라)
	//		action="update.do" 입력된 회원 전체 수정정보 전송
		String userid = (String) session.getAttribute("userid");
		if(userid == null){
			out.print("<script>alert('유효하지 않은 세션/접근 개실패');</script>");
			out.print("<script>location.href='login.jsp'</script>");
			return;
		}
	%>
	
	<script type="text/javascript">
	 alert("Update Success!")
	</script>
	
	<h1><%=userid %>친구여...변덕생긴 내용 읊어라</h1>	
	<form action="update.do" method="post">	
		아디 : <input type="text" name="userid" value=<%=userid%> readonly="readonly"><br> 
		비번(re) : <input type="password" name="password"><br> 
		이멜(re) : <input type="email" name="email"><br> 
		이멜수신 여부 : <input type="radio" name="emailAgree" value="agree" checked>녜 
		<input type="radio" name="emailAgree" value="disAgree">아뇨<br>
		관심사(하나라도 골라라): <input type="checkbox" name="interest" value="study" checked>공부 
		<input type="checkbox" name="interest" value="movie">영화 
		<input type="checkbox" name="interest" value="music">음악 
		<input type="checkbox" name="interest" 	value="webtoon">웹툰<br> 
		핸폰(re) : <input type="text" name="phone"><br> 
		소개(re) : <br><textarea cols="30" rows="10" name="introduce"></textarea><br> 
		<br><input type="submit" value="전송">
	</form>

</body>
</html>