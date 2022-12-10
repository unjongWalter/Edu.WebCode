package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : user 세션 제거 , 세션 제거 후에 login.jsp로 이동
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// logout 이후 session 제거시킴		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");		
		
		if(userid != null) {
			session.removeAttribute("userid");
			System.out.println("유효 세션 확인용");			
			response.sendRedirect("/Homepage/login.jsp"); // 샘이 추천한 내용
			
		} else {
			System.out.println("유효 않은 세션 확인용");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
