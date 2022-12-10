<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Param/Sender(Giver)</title>
</head>
<body>
   <h1>회원 가입 form = parameter</h1>
   <form action="03_parameter.jsp" method="post">
    <p>아이디</p>
    <input type="text" name="userid" placeholder="아이디 입력">
    <p>패스워드</p>
    <input type="password" name="password" placeholder="비밀번호 입력">
    <p>이메일</p>
    <input type="text" name="email" placeholder="이메일 입력">
    <p>이메일 수신여부</p>
    <input type="radio" name="emailAgree" value="yes">예 <input
      type="radio" name="emailAgree" value="no" checked="checked">아니오

    <p>관심사항</p>
    <input type="checkbox" name="interest" value="IT">IT/인터넷 <input
      type="checkbox" name="interest" value="movie">영화 <input
      type="checkbox" name="interest" value="music">음악 <input
      type="checkbox" name="interest" value="book">책 <input
      type="checkbox" name="interest" value="food">음식

    <p>핸드폰</p>
    <input type="text" name="phone" placeholder="번호 입력">

    <p>자기소개</p>
    <textarea rows="4" cols="30" name="introduce" placeholder="자기소개 입력"></textarea>
    <br> <input type='submit' value="전송">
  </form>
</body>
</html>