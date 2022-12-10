<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result</title>
</head>
<body>
	<%
	// TODO : userid야 환영떄린다. 페이지 출력 5번째	
	// TODO : 회원 정보 이동 버튼 생성	
	// TODO : 로그아웃 버튼 생성
	
	// 세션 릴레이용 ...
		String userid = (String) session.getAttribute("userid");
	
		/* if(userid == null){
			out.print("<script>alert('유효하지 않은 세션/접근 개실패');</script>");
			out.print("<script>location.href='login.jsp'</script>");
			return;
		} else { */
	%>
	
	<script type="text/javascript">		
    alert("Congrats! Login Success!")
    </script>
    
	<!-- GET 방식 userid 전송, 포워딩말고 세션활용해라-->
	<h1>로그인 페이지</h1>
	<p><%=userid %>야, 환영때린다</p>
	
	<button onclick="location.href='select.do?userid=<%=userid%>'">회원정보</button>
	
	<!-- logout은 원래 get방식으로 하면 뒤진다... -->
	<button onclick="location.href='logout.do?userid=<%=userid%>'">로그아웃</button>
	<%
	//	}
	%>	
	
</body>
</html>