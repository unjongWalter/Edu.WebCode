package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : login-result.jsp에서 전송받은 userid로 DB에서 회원 정보 select
// 		select 데이터를 member-result.jsp에 전송
//		doGet() 메소드에서 처리

@WebServlet("/select.do") // 6번쨰
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public SelectServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.println("select.do 생성자");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
			
		
		if (userid != null) { // DB에서 제대로 success?
			
			// 읽어오고 써보자잉			
			MemberVO vo = dao.select(userid);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("member-result.jsp");
			request.setAttribute("vo", vo);
			dispatcher.forward(request, response);
			
			System.out.println(userid + "로그");		
			System.out.println(vo + "회원 정보는 보여준데이.");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
//
//			} else { // DB에서 제대로 ㄴㄴ
//				request.setAttribute("selectResult", "Fail");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//				dispatcher.forward(request, response);
//			}
//		} else { // URL로 잘못 접근
//			request.setAttribute("wrongApproach", "fail");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		
	}

}
