package edu.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public LoginServlet() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * json library download
		// https://code.google.com/archive/p/json-simple/downloads
				
		String obj = request.getParameter("obj");
		System.out.println(obj);		
		JSONParser parser = new JSONParser(); // json simple ~
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			System.out.println(jsonObject);
			
			String userid = (String) jsonObject.get("userid");
			String password = (String) jsonObject.get("password");
			System.out.println(userid);
			System.out.println(password);
			
			if(userid.equals("test") && password.equals("1234")) {
				PrintWriter out = response.getWriter();
				out.append("success");
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}				
		
//		doGet(request, response);
	}

}
