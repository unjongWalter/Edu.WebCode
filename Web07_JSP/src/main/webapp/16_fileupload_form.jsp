<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<!-- 
	* 파일 업로드 구현 순서
	1. web.xml에 <context-param>을 설정
	2. commons-fileupload-x.x.jar을 다운로드 및 WEB_INF/lib 폴더 저장
	3. commons-io-x.x.jar을 다운로드 및 WEB-INF/lib 폴더에 저장
	4. c:\tmp의 c:\server\apache-tomcat-9.0.65\webapps\data 폴더 생성
	cf> WEB_INF : 라이브러리 또는 프로젝트 관련 설정 저장 폴더(위치)
	서버 가동 : 내 PC에 외부 접근 허가.
	 -->

	<h2>File Upload</h2>
	<p>select file : </p>
	<form action="16_uploadfile.jsp" method="post" enctype="multipart/form-data">
		<input type="text" name="name"><br>
		<input type="file" name="files" size="1000" multiple="multiple"><br>
		<input type="submit" value="file upload"><br>
	</form>

</body>
</html>