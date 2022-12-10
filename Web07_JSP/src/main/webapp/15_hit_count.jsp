<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hit Count</title>
</head>
<body>
	<%
		// application 객체는 서버가 재시작할 때 초기화
		Integer hitsCount = (Integer) application.getAttribute("hitCounter");
		if(hitsCount == null || hitsCount == 0){
			out.println("어서온나 처음이제?");
			hitsCount = 1;
		} else {
			out.println("또왔나?");
			hitsCount += 1;
		}
		application.setAttribute("hitCounter", hitsCount);
	
	%>

	<p>또 온 숫자 : <%=hitsCount %></p>

</body>
</html>