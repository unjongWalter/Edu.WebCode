package edu.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() {

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = "test";
		String password = "1234";
		String email = "test@test.com";
		
		// JSON 객체 생성
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userid", userid);
		jsonObject.put("password", password);
		jsonObject.put("email", email);
		
		// JSON 객체 전송
		response.getWriter().append(jsonObject.toString());
				
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
