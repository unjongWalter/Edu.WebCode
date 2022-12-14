package edu.web.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.go")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlURI(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlURI(request, response);
	}

	private void controlURI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println(requestURI);
		System.out.println(requestMethod);
		
		if(requestURI.contains("login")) {
			System.out.println("login call");
			if(requestMethod.equals("GET")) {
				loginGET(request, response);				
			} else if(requestMethod.equals("POST")) {
				loginPOST(request, response);
			} 			
		} else if(requestURI.contains("logout")) {
			System.out.println("logout call");
			logout(request, response);			
		}		
	}//end controlURI
	
	private void loginGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginGET() call");
		String targetURL = request.getParameter("targetURL");
		if(targetURL != null) {
			HttpSession session = request.getSession();
			session.setAttribute("targetURL", targetURL);
		}
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);	
		
	}//end loginGET

	private void loginPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginPOST() call");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		
		System.out.println("memberId : " + memberId);
		System.out.println("password : " + password);
				
		if(memberId.equals("test") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			session.setMaxInactiveInterval(600);
			
			// ????????? target url ????????????
			String targetURL = (String) session.getAttribute("targetURL");
			System.out.println("targeturl : " + targetURL);
			
			if(targetURL != null) { // targetURL ????????? ???(??? ?????? ?????? -> ?????????)
				session.removeAttribute("targetURL");
				response.sendRedirect(targetURL);
				
			} else { // targetURL ?????????(????????? ?????????)
				response.sendRedirect("index.jsp");
			}		
			
		} else {
			PrintWriter out = response.getWriter();
			out.print("<head><meta charset='UTF-8'></head>");
			out.print("<script>alert('????????? ??????')</script>");
			out.print("<script>location.href='login.go';</script>");
			response.sendRedirect("login.go");
		}
	
	}//end loginPOST

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logoutGET ????????????");
		// session??? ???????????? ??????????????? ?????????????????? ????????? ?????????????????? ????????? ?????? ????????????
		// ????????? ???????????? ????????? attribute ????????? ?????????
		
		HttpSession session = request.getSession();
		session.removeAttribute("memberId");
		response.sendRedirect("index.jsp");		

	}//end logout

}//end login.go
