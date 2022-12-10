<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 ? ? ?</title>
</head>
<body>
	<%--
	1. HW3.jsp 파일
	- 회원가입 form 맹글라
	- post 방식
	- action="HW3_member_info.jsp"
	- id(text) : name="userid"
	- pa(password) : name="password"
	- email(email) : name="email"
	- email 수신여부(radio 버튼) : name="emailAgree"
	- 관심사(checkbox, 관심사항 4개 이상 설정) : name="interest"
	-> 4개이상이라 배열형태로 자동으로 묶어서 넘어간대...? getParameters
	- phone(text) : name="phone"
	- 자기소개(<textarea>) : name="introduce"
	- 전송버튼(submit)	
	
	2. MemberVO.java 파일
	- jsp:useBean 사용
	- src.edu.web.homework 패키지에 MemberVO.java 클래스 생성
	(변수는 위의 아이디, 패스워드 등과 갯수 및 변수명 매칭필수)
	- * MemberVO 기본 생성자 및 매개변수생성자, 써라.
	- * String[] interest; (관심사항은 배열로 변수 선언해라)
	
	3. HW3_member_info.jsp 파일
	- HW3에서 전송받은 데이터를 출력
	- request.getParameter or request.getParameterValues 아닌걸로 구현해봐
	- 아래 코드로 대체 가능
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	<jsp:setProperty property="*" name="member" />
	- property="*"의 의미 : HW3.jsp에서 넘어온 모든 parameter 값을 member에 저장		
	 --%>

	<form action="HW3_member_info.jsp" method="post">
	<h1>너의 정보를 털러왔도다</h1>
	아디 : <input type="text" name="userid"><br>
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