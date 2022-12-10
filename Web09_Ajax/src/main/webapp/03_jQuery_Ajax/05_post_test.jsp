<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// do service area...
	String name = request.getParameter("name");
	String city = request.getParameter("city");

	out.write("name : " + name + ", city : " + city);
	
%>