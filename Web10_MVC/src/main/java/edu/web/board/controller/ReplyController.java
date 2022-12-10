package edu.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.web.board.domain.ReplyVO;
import edu.web.board.persistence.ReplyDAO;
import edu.web.board.persistence.ReplyDAOImple;


@WebServlet("/replies/*")
public class ReplyController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private ReplyDAO dao;   
    
   public ReplyController() {
       dao = ReplyDAOImple.getInstance();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      controlURI(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      controlURI(request, response);
   }

   private void controlURI(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      String requestURI = request.getRequestURI();
      String requsetMethod = request.getMethod();
      System.out.println(requestURI);
      
      // insert/add
      if(requestURI.contains("add")) {
         System.out.println("add 호출 확인");
         replyAdd(request, response);
         
         // list call
      } else if(requestURI.contains("all")) {
         System.out.println("all 호출 확인");
         replyList(request, response);
         
         // update call
      } else if(requestURI.contains("update")) {    	  
    	  System.out.println("update");
    	  replyUpdate(request, response);
      
    	  // delete
      } else if(requestURI.contains("delete")) {
    	  System.out.println("delete");
    	  replyDelete(request, response);    	  
      }
            
   } // end controlURI

   private void replyAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String obj = request.getParameter("obj");
      System.out.println(obj);
      JSONParser parser = new JSONParser();
      
      JSONObject jsonObject;
      try {
    	  // JSON Parameter -> JSONObject parse
         jsonObject = (JSONObject) parser.parse(obj);
         System.out.println(jsonObject);
         
         // 각각 꺼내어 vo 저장 from JSONObject
         int boardId = Integer.parseInt((String) jsonObject.get("boardId"));
         String memberId = (String) jsonObject.get("memberId");
         String replyContent = (String) jsonObject.get("replyContent");
         
         ReplyVO vo = new ReplyVO(0, boardId, memberId, replyContent, null);
         System.out.println(vo);
         
         // DB insert
         int result = dao.insert(vo);
         if(result == 1) {
        	// 성공시 append("sucess") 내용을 detail.jsp 의
			// success : function(result)의 result로 보냄
            response.getWriter().append("success");
         }         
      } catch (ParseException e) {
         e.printStackTrace();
      }
      
   } // end replyAdd()

   private void replyList(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
	// get방식 파라미터로 받은 boardId
	   int boardId = Integer.parseInt(request.getParameter("boardId"));
	// DB에서 댓글 목록을 리스트에 담음
	   List<ReplyVO> list = dao.select(boardId);
	// JSONObject 와 JSONArray는 JSON 문법에 맞춰 key value로 데이터를 변환해주는 라이브러리
	// JSONArray에 List<ReplyVO>를 풀어서 하나씩 담음
      JSONArray jsonArray = new JSONArray();
      for(int i = 0; i < list.size(); i++) {
         JSONObject jsonObject = new JSONObject();
         ReplyVO vo = list.get(i);
         // key value 방식으로 put하는 jsonArray ...
         jsonObject.put("replyId", vo.getReplyId());
         jsonObject.put("boardId", vo.getBoardId());
         jsonObject.put("memberId", vo.getMemberId());
         jsonObject.put("replyContent", vo.getReplyContent());
         jsonObject.put("replyDateCreated", vo.getReplyDateCreated().toString()); // Date 인식 불가
         jsonArray.add(jsonObject);
      }
      
      System.out.println(jsonArray.toString());
   // response에 JSONArray을 담음
      response.getWriter().append(jsonArray.toString());
   } // end replyList()
   
   private void replyUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int replyId = Integer.parseInt(request.getParameter("replyId"));
	   String replyContent = request.getParameter("replyContent");
	   
	   // 0, "", null 비워두기 개념적 정리...
	   ReplyVO vo = new ReplyVO(replyId, 0, "", replyContent, null);
	   int result = dao.update(vo);
	   
	   if(result == 1) {
		   response.getWriter().append("success");
		   		   
	   }	   
	   
   }//end replyUpdate
     
   private void replyDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int replyId = Integer.parseInt(request.getParameter("replyId"));
	   int result = dao.delete(replyId);
	   
	   if(result == 1) {
		   response.getWriter().append("success");
				   
	   }
	   	   
   } //end replyDelete
   
}//end ReplyController
