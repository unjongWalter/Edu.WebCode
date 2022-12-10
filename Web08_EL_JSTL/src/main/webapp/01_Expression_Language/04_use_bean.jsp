<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL useBean</title>
</head>
<body>
	<h1>EL useBean practice</h1>
	<jsp:useBean id="point" class="edu.web.el01.Point" scope="page" />
	<jsp:setProperty property="x" name="point" value="0.0"/>
	<jsp:setProperty property="y" name="point" value="0.0"/>
	<p>point의 x, y 좌표값 : ${point.x }, ${point.y } </p>
	<p>point의 x, y 좌표값 : ${pageScope.point.x }, ${pageScope.point.y } </p>
	
	<%--el method --%>
	<p> 좌표 거리 : ${point.distance(1,2) }</p>
	<p> 좌표 출력 : ${point.toString() }</p>

</body>
</html>