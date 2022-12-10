<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- to receive the files from 16_-->
<%
	request.setCharacterEncoding("UTF-8"); 
	String realPath = "";
	String savePath = "images";
	String type = "UTF-8";
	int maxSize = 10 * 1024 * 1024;
	ServletContext context = request.getServletContext(); // 현재 애플레케이션 정보 저장
	realPath = context.getRealPath(savePath); // 서버 url의 실제 경로
	
	out.print(realPath + "<br>");

	
	try {
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setRepository(new File(realPath));
		diskFileItemFactory.setSizeThreshold(maxSize);
		diskFileItemFactory.setDefaultCharset("UTF-8");
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		
		List<FileItem> items = fileUpload.parseRequest(request); // request 정보를 가져와서 upload 형태에 맞게 파싱
		for(FileItem item : items) {
			// file checked
			if(item.isFormField()) { // is file~ checked				
				out.print(item.getString() + "<br>"); // parameter data
			} else { // if file data is correct...
				out.print("file name : " + item.getName() + ", file size : 	" + item.getSize() + "<br>");
				if(item.getSize() > 0) {
					String separator = File.separator;
					int index = item.getName().lastIndexOf(separator);
					String fileName = item.getName().substring(index + 1);
					File uploadFile = new File(realPath + separator + fileName);
					item.write(uploadFile); // upload the file ... to the server...
					out.print(uploadFile);
					
					// 다른 jsp에서 이미지 보기
					response.sendRedirect("/Web07_JSP/16_image_view.jsp");
					session.setAttribute("fileName", fileName);	
				}			
			}
		}
		
	} catch (Exception e){
		
	}
	
	%>