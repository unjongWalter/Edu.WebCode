<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content Register</title>
</head>
<body>
	<h2>Writer</h2>
	<form action="register.do" method="POST">
	
		<div>
			<p>title : </p>
			<input type="text" name="boardTitle" placeholder="enter the Title" required>		
		</div>
		
		<div>
			<p>writer : </p>
			<input type="text" name="memberId" value="${sessionScope.memberId }" readonly >		
		</div>
	
		<div>
			<p>content : </p>
			<textarea rows="20" cols="120" name="boardContent" placeholder="content" required>
			</textarea>
		</div>
		
		<div>			
			<input type="submit" value="submit">		
		</div>
		
	</form>
</body>
</html>