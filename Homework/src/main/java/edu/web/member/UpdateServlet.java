package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO  : member-update.jsp에서 전송받은 데이터로 DB회원정보 수정
//		db 회원 정보 수정 성공 시 memeber-result.jsp로 vo데이터 전송하여 보이기

@WebServlet("/update.do")// 9번째, do는 서블릿
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
    
    public UpdateServlet() {
    	dao = MemberDAOImple.getInstance();
		System.out.print("update.do 생성자 ㄱㄱ");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URL로 직접접근할 경우 경로 우회시킴		
		// 단순 1번
		response.sendRedirect("/Homepage/member-register.jsp");
			
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('잘못된 접근입니다.');location.href='/Homepage/login.jsp'; </script>");
		writer.close();
		// 복잡 2번
//		request.setAttribute("wrongApproach", "fail");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");

		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo); // 로그확인용
		int result = dao.update(vo);
		System.out.println(result + "업댓 이까지는 나오네... "); // 로그확인용
		
		if (result == 1) { // DB 저장에 성공하면 다른 페이지에 데이터 전송, 세션은 낫굳
			
			// 요청받은 request에 포워딩			
			request.setAttribute("updateResult", "success");
			request.setAttribute("vo", vo); // vo로 데이터 변경사항 적용/쓰기
			
			// 순서 위랑 바꿔도 되나? response.sendRedirect로 하는게 낫나?
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member-result.jsp");
			dispatcher.forward(request, response);
			System.out.println("변경 성공");
			
		} else { // 실패
			request.setAttribute("updateResult", "fail");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('수정 사항을 모두 입력해주세요.');location.href='/Homepage/member-update.jsp'; </script>");
			writer.close();
		}
	}
}
