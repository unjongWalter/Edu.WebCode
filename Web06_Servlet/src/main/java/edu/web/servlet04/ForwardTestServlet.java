package edu.web.servlet04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * info.html -> /forward -> result.jsp(html 코드 작성)
 */
@WebServlet("/forward")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = ForwardTestServlet.class.getName();
   
    public ForwardTestServlet() {        
    }
    
    // forward : URL 주소 유지. request/response 객체 유지
    // - 같은 웹 서버 내에 있는 파일들로만 이동이 가능 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "goGet() 호출!!");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// vo에도 변수명 똑같이 해라 딴소리 ㄴ,
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		int money = Integer.parseInt(request.getParameter("money"));
		
		System.out.println("name : " + name + ", age : " + age + ", email : " + email + ", money : " + money);
	
		/* 존재하는 JSP페이지에 데이터를 보내는 방식 */
		// info.html -> ForwardTestServlet.java(/forward) -> result.jsp
		// request를 통해 1단은 쉽게? 했대...
		// html은 데이터를 읽어오는 동적 기능이 없기에 jsp로 데이터를 받아와야 함
		
		// forward 방식에서 페이지를 이동할 때는
		// RequestDispatcher interface의 forward(request, response)메소드 사용
		// URL이 변경되지 않고 이동함
		ServletContext context = getServletContext(); // 이미 있는 것 꺼내서 가져온데이
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");// to where
				
		// request 객체를 jsp로 전달
		dispatcher.forward(request, response);
		// result.jsp에 request 객체를 전달하고
		// 전달받은 request에서 parameter를 꺼내는 방식
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "goPost() 호출");
		//doGet(request, response);	
	
	}

}
