<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="login.go" method="POST">
		<input type="text" name="memberId" placeholder="id" required autofocus>
		<br>
		<input type="password" name="password" placeholder="pw" required>
		<br>
		<input type="submit" value="login">
		
	</form>

</body>
</html>