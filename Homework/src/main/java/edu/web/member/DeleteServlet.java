package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : member-result.jsp 값 button에서 전송받은 userid를 이용하여
//			DB에서 회원 정보 삭제, 삭제 성공 후에 login.jsp로 이동
// 세션 제거 removeAtt
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAOImple dao;

	public DeleteServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.println("delect.do 생성자");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
//		System.out.println(result + "삭제가...이까지는 나오네... "); // 로그확인용

		if (userid != null) {
			int result = dao.delete(userid);
//		if (result == 1) { // DB 저장에 성공하면 다른 페이지에 데이터 전송, 세션은 낫굳
			// 요청받은 request에 포워딩
			// request.setAttribute("vo", vo); // vo로 데이터 변경사항 적용/쓰기

			session.removeAttribute(userid);
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
