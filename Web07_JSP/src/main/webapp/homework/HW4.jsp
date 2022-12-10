<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

</head>
<body>
	<!-- 
	1. 로그인 정보 전송 페이지(HW4.jsp)
	- <form>
	- id, pw 전송(action="HW4_login_auth.jsp")
	
	2. 로그인 인증 jsp 생성(HW4_login_auth.jsp)
	- 전송받은 id, pw를 확인하여 id=="test", pw="1234"일 경우
	  id, pw 세션을 생성(만료 시간 자유)
	  세션을 생성한 이후에 HW4_login_result.jsp 페이지로 이동
	  -> out.print("<script>location.href='HW4_login_result.jsp'</script>");
	  - 전송받은 id, pw가 불일치 시, HW4.jsp 페이지로 이동
	  
	3. 로그인 결과 jsp 생성(HW4_login_result.jsp)
	- 세션에서 id값을 꺼내서 출력
	- 만약 url로 직접 접속할 경우 '로그인 해라'라고 alert를 띄우고
	  HW4.jsp 페이지로 이동	
	  -> out.print("<script>alert('로긴 ㄱ');</script>");
	  	  
	  
	  구조 : 일반1, 로긴어토2, 로긴결과3
	  : 1 시도하여 어토로 보냄, 2에서 매칭하면 세션 생성 후 3으로 넘김
	  2에서 매칭ㄴㄴ면 일반으로 다시 보내, 알러트 띄워
	  3에서 세션 생성과 함께 아디 출력하는디, 과정무시하고 바로오면 알러트 띄워
	  
	  일반 아디 패스 입력
	  
	  로긴 어토에서 
	  꺼내, 아디 비번 매칭하면? / 매칭 ㄴㄴ 하면?
	  	매칭되면 세션생성 후 결과로
	  	매칭안되면 일반으로 가, 알러트 띄워
	  
	  로긴 결과
	  	아디출력
	  
	  	로긴도 안하고 결과페이지로 직접 접속하면 
	  	알러트 또 ㄱ	  
	 -->

	<form action="HW4_login_auth.jsp" method="get">
	<h1>로그인 수작질</h1>
	아디 : <input type="text" name="useridHW"><br>
	비번 : <input type="password" name="passwordHW"><br>	
	<br><input type="submit" value="전송">
	</form>

</body>
</html>