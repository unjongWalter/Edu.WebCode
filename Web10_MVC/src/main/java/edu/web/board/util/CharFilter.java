package edu.web.board.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/charFilter")
public class CharFilter extends HttpFilter implements Filter {
   
    public CharFilter() {
        super();
       
    }
	
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 한글로 인코딩 ㄱ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); // response 왜 뺴먹냐 시발
//		request.getRemoteAddr();
//		System.out.println("눈데?" +request.getRemoteAddr());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
