package edu.web.servlet06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;

@WebServlet("/redirect") // request(택배차) url(추석 한우세트)
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RedirectServlet() {    
    }

	// redirect : URL 주소 바뀜. request/response 객체 소멸
    // - 같은 서버/다른 서버에 있는 페이지로 이동 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect를 이용한 데이터 전송 방법(only GET type)
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	
		String path = request.getContextPath(); // /Web06_Servlet
		String pageName = "/result.jsp";
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String money = request.getParameter("money");
		String location = path + pageName +
						"?name=" + name +
						"&age=" + age +
						"&email=" + email +
						"&money=" + money;
		System.out.println(location);
		response.sendRedirect(location);
//		URLEncoder(name, "UTF-8");		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);		
	}
}
