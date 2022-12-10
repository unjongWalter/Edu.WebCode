package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.do")// 3번
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public RegisterServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.print("register.do 생성자");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// URL 직접 접근 떄 혼구뇽
		// 단순 1번
		 response.sendRedirect("/Homepage/member-register.jsp");
		
		
		// 복잡 2번
//		request.setAttribute("wrongApproach", "fail");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//		dispatcher.forward(request, response);
//		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");

		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce); // 한데 묶어라
		System.out.println(vo); // 전달될때 오류발생 가능성 높다. 로그확인용
		int result = dao.insert(vo);
		System.out.println(result + "은 성공, 고로 등록 된데이"); // 로그확인용

		
		
		// 이상행행행
		PrintWriter out = response.getWriter(); // alert를 위해 선언
		if (result == 1) { // DB저장에 성공 시, 다른 페이지로 데이터 전송
			// 요청받은 request에 포워딩			
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('한글 추카 & Eng congrats!');</script>");
			out.print("<script>loaction href='login.jsp';</script>");
			out.print("</head>");
			// 시점 영역으로 인해 바로 띄우고, 보내고 안된다.
		
			// 밑에는 싹 지우까? 안나올걸?
//			request.setAttribute("vo", vo); // 내용 등록 변경을 set vo
//			request.setAttribute("insertResult", "success");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
//			dispatcher.forward(request, response);
			
			
			System.out.println("회원가입 성공");
		} else if (result == -1) { // 중복 아디? 어제하던거 ㄱㄱ
			request.setAttribute("insertResult", "idPKFail");
			RequestDispatcher dispatcher = request.getRequestDispatcher("member-register.jsp");
			dispatcher.forward(request, response);
		} else { // 그외 기등타등
			request.setAttribute("insertResult", "fail");
			RequestDispatcher dispatcher = request.getRequestDispatcher("member-register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
