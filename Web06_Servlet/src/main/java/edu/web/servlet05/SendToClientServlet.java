package edu.web.servlet05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class SendToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String CLASSNAME = SendToClientServlet.class.getName();
	
    public SendToClientServlet() {        
    }

    // key value : 택배에 라벨링 붙이고 보내는 형태
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * request.setAttribute / request.getAttribute
		// - 데이터를 key-value 형식으로 전송하는 방식
		// - 문자열 뿐만 아니라, 다양한 변수 및 객체를 전송할 수 있음
		// * attribute와 parameter의 차이점
		// - parameter는 html form 태그를 통해 데이터 전송
		// ************** (form 외의 위치에서 데이터 추가 불가능)
		// - parameter는 String 형태로 값을 전송
		// - form태그 아니면 parameter ㄴㄴㄴㄴ
		
		// - attribute는 client/server에서 생성하여 전송 가능
		// - attribute는 문자열 뿐만 아니라, 다양한 변수 타입 및 참조 타입 전송 가능
		
		request.setAttribute("name", "곡긱독");
		request.setAttribute("lived", "썅뮨둉");
		request.setAttribute("age", 400); // object 형식이라 잡다구리 다구리 가능
		InfoVO vo = new InfoVO("돌리", "셔율 썅뮨둉", 999);
		request.setAttribute("vo", vo);	
		response.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/my_info.jsp");		
		dispatcher.forward(request, response);
		
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
