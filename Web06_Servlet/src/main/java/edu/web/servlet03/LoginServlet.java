package edu.web.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest") // login html에서 이름 일치시켜라...
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = LoginServlet.class.getName();

	public LoginServlet() {}

	// doGet() : form method = "GET" 방식으로 전송할 경우 doGet()으로 수신
	// request가 택배내용(data)을 담고 있다...?
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 요청 파라미터(request parameter)의 값을 읽는 방식
		// http://localhost:8080/Web06_Servlet/loginTest?userid=d&password=dd
		// GET 방식에서 요청파라미터는 URL 주소의 query string에 포함됨.
		// ? 뒤는 쿼리 스트링!
		// 브라우저 -> F12(개발자툴) -> Network -> 생성된 주소로 확인 가능
		// - http : 프로토콜
		// - localhost : 서버 주소(도메인 이름)
		// - 8080 : 포트 번호
		// - Web06_Servlet : context root(서버에서 파일을 찾아갈 최초 경로)
		// - loginTest : servlet 경로(urlPattern)
		// - ?userid=test&password-1234 : query string
		
		System.out.println(CLASSNAME + "doGet() 호출");
		login(request, response);

	}

	// doPost() : form method = "POST" 방식으로 전송할 경우 doPost()으로 수신
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(CLASSNAME + "doPost() 호출??");
		login(request, response);
	}

	// HttpServletRequest : 요청한 HTTP의 객체(ip주소, 파라미터 등)을 저장하는 클래스
	// HttpServletResponse : HTTP 요청에 대응하는(보내는) 정보를 저장하는 클래스
	// * 중요 : request와 response의 객체를 생성하고 호출하는 역할은 서버에서 컨트롤
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 브라우저에서 받은 데이터를 꺼내는 방식 */
		String ip = request.getRemoteAddr(); // 요청한 HTTP의 IP주소를 얻어옴
		System.out.println("[" + ip + "]");
		// 요청 파라미터(request parameter)의 값을 읽어옴
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		System.out.println("id : " + userid);
		System.out.println("pw : " + password);

		// 새로운 페이지를 생성하는 방식
		// 요청에 대응하는 데이터 인코딩설정
		response.setCharacterEncoding("UTF-8");

		// PrintWriter Class
		// - HTML page를 생성해주는 class
		PrintWriter out = response.getWriter();

		out.append("<!DOCTYPE html>").append("<head><meta charset='utf-8'></head>").append("<body>")
				.append("<h1>로그인 결과 페이지</h1>").append("아이디 : " + userid + "<br>").append("비번 : " + password + "<br>")
				.append("</body>").append("</html>");

	}

}
