<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update page</title>
</head>
<body>
<body>
	<h2>Writer</h2>
	<form action="update.do" method="POST">
	
		<div>
			<p>boardId : ${vo.boardId }</p>
			<input type="hidden" name="boardId" value="${vo.boardId }">
		</div>	
	
		<div>
			<p>title : </p>
			<input type="text" name="boardTitle" value="${vo.boardTitle }">		
		</div>
		
		<div>
			<p>writer : ${vo.memberId }</p>
			<p>boardDateCreated : ${vo.boardDateCreated }</p>		
		</div>
	
		<div>
			<p>content : </p>
			<textarea rows="20" cols="120" name="boardContent">
			${vo.boardContent }</textarea>
		</div>
		
		<div>			
			<input type="submit" value="submit">		
		</div>
		
	</form>
</body>
</html>