package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO :
/* 
* 입력받은 아디 비번을 DB와 비교하여
* 데이터 일치 시, 로그인 성공(login_result.jsp)로 이동 및 로그인 세션 생성(아이디 유지)
* * (아이디 값에 대한 세션 생성)
* - 예시> session.setAttribute("userid", 아디 값);
* 데이터 불일치 시, 알림창 + login.jsp 이동(alert ok) // 포워딩말고 세션활용
*/

@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	private static MemberVO vo;

	public LoginServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 단순 1번
		response.sendRedirect("/Homepage/member-register.jsp");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(
				"<script>alert('잘못된 접근입니다. 로그인 페이지에서 로그인 해주세요.');location.href='/Homepage/login.jsp'; </script>");
		writer.close();
		
		// URL로 직접접근할 경우 경로 변경위해 key-value
//		request.setAttribute("wrongApproach", "fail");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8"); 불필요해짐. 필터로 ㄱ
		
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		// daoimple과 함께 봐라... 슈밥
//		String checkUser = dao.login(userid, password);
		
		vo = dao.login(userid, password);
		System.out.println(vo); // log 
		
		// alert를 띄우기 위한 여정
		PrintWriter out = response.getWriter();
		if (vo != null) { // login success
			HttpSession session = request.getSession();
			
			// session attribute에 데이터저장
			session.setAttribute("userid", vo.getUserid());
			session.setMaxInactiveInterval(60);
			
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('한글 login 추카');</script>");
			out.print("<script>loaction href='login-result.jsp';</script>");
			out.print("</head>");
			
			// out.print 스크립트문이랑 동일
//			response.sendRedirect("login-result.jsp");

		} else {
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('한글 fail. 눈단디떠라');</script>");
			out.print("<script>loaction href='login.jsp';</script>");
			out.print("</head>");			
			
//			response.sendRedirect("login.jsp");
		}
	}
}
