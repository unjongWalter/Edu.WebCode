<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Register2번</title>
</head>
<body>
	<%
	// TODO : Join form action="register.do"
		System.out.println("member-register.jsp page");
	
	%>
		
	<h1>너의 정보를 털러왔도다</h1>
	<form action="register.do" method="post">
	
	아디 : <input type="text" name="userid" placeholder="아뒤뒤뒤뒤"><br>
	비번 : <input type="password" name="password"><br>
	이멜 : <input type="email" name="email"><br>
	이멜수신 여부 : <input type="radio" name="emailAgree" value="agree" checked>녜
				<input type="radio" name="emailAgree" value="disAgree">아뇨<br>
	관심사(하나라도 골라라): <input type="checkbox" name="interest" value="study" checked>공부
		<input type="checkbox" name="interest" value="movie">영화
		<input type="checkbox" name="interest" value="music">음악
		<input type="checkbox" name="interest" value="webtoon">웹툰<br> 		
	핸폰 : <input type="text" name="phone"><br>
	소개 : <br><textarea cols="30" rows="10" name="introduce"></textarea><br>
	<br><input type="submit" value="전송">
	</form>

</body>
</html>