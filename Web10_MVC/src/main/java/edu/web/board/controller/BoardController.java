package edu.web.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAO;
import edu.web.board.persistence.BoardDAOImple;
import edu.web.board.util.PageCriteria;
import edu.web.board.util.PageMaker;

// /Goott_Board/index.jsp : jsp로 시작...
// 처음부터 DB에서 data를 가져와야해... select dt call... 문제없애려고 jsp를 중간중간에...
// index.jsp -> list.do(boardcontroller) -> web-inf/board/list.jsp
@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 대한 모든 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// to separate the each ~ : ex. list.do vs detail.do vs register.do
    private static final String BOARD_URL = "WEB-INF/board/"; // default path
    private static final String MAIN = "index";
    private static final String LIST = "list";
    private static final String REGISTER = "register";
    private static final String DETAIL = "detail";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String EXTENSION = ".jsp";
    private static final String SERVER_EXTENSION = ".do";
    
    private static BoardDAO dao;
    
    // list method 사용 시, dao 갖고온나.
    public BoardController() {
    	dao = BoardDAOImple.getInstance();
    } 
// WEB-INF 하위에 jsp 파일을 두면, 컨트롤러를 통해서만 접근가능하며 직접주소로는 404에러 발생
 	// webapp 하위경로에 뒀을때는 직접 접근 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/board/list.jsp");
//		dispatcher.forward(request, response);		
		controlURI(request, response);						
	}//end doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		controlURI(request, response);		
	}//end doPost

	private void controlURI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request에는 URI같은 개념이 이미 다 들어있어..., do 분류작업 고
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println("requestURI : " + requestURI);
		System.out.println("requestMethod : " + requestMethod);
		
		// list call - list.jsp(do)
		if(requestURI.contains(LIST + SERVER_EXTENSION)) {
			System.out.println("list call");			
			list(request, response);
		
		// register call
		} else if(requestURI.contains(REGISTER + SERVER_EXTENSION)) {
			System.out.println("register call");
			if(requestMethod.equals("GET")) { // get type, call the page
				registerGET(request, response);
			} else if(requestMethod.equals("POST")) { // save the dt into db
				registerPOST(request, response);
			}
		// detail call
		} else if(requestURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("datail call");			
			detail(request, response);
		// update call
		} else if(requestURI.contains(UPDATE + SERVER_EXTENSION)) {
			System.out.println("update call");
			if(requestMethod.equals("GET")) { // get type, call the page
				updateGET(request, response);
			} else if(requestMethod.equals("POST")) { // save the dt into db
				updatePOST(request, response);
			}
		// delete
		} else if(requestURI.contains(DELETE + SERVER_EXTENSION)) {
			System.out.println("delete call");
			if(requestMethod.equals("POST")) {
				deletePOST(request, response);
			} 						
		}		
	}//end controlURI
	
	// throws == try~catch Exception (1) ++ pagescope...
	// 전체 게시판내용을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 보내기(dao, imple 불러온나)
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 초기구동시 page가 null이면 parseInt시 예외발생하기 때문에 String으로 받아서
		// List<BoardVO> list = dao.select(); // boardVO 불러왕
		// 페이징 처리를 위해 기존작업 변경
		
		// 에러이유? Int page -> String page...
		PageCriteria criteria = new PageCriteria();
		
		String page = request.getParameter("page");
		System.out.println(page);
		if(page != null) { // not null == set the page
			criteria.setPage(Integer.parseInt(page)); // 페이지마다 값 변화
		}
		
		String numsPerPage = request.getParameter("numsPerPage");
		if(numsPerPage != null) { // not null == set the page
			criteria.setNumsPerPage(Integer.parseInt(numsPerPage));
		}
		
		List<BoardVO> list = dao.select(criteria);
		if(!list.isEmpty()) {
		// /board/list.jsp로 보내긩		
		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("list", list); // list를 attr 방식으로 쓰고
		
		// 페이지 링크 번호에 대한 정보를 구성하여 list.jsp 페이지 전송
		// 현재 페이지 및 한 페이지 당 게시글 개수 정보 저장
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 저클래스 객체를 바로 넘겨준대
		int totalCount = dao.getTotalCounts(); // 전체 게시글 수
		pageMaker.setTotalCount(totalCount);// 전체 게시글 수 저장
		pageMaker.setPageData(); // 저장된 데이터를 바탕으로 page 링크 데이터 생성
		System.out.println("totalCount : " + pageMaker.getTotalCount());
		System.out.println("getPage : " + criteria.getPage());
		System.out.println("numsPerPage : " + criteria.getNumsPerPage());
		System.out.println("numsOfPageLinks : " + pageMaker.getNumsOfPageLinks());
		System.out.println("startPageNo : " + pageMaker.getStartPageNo());
		System.out.println("endPageNo : " + pageMaker.getEndPageNo());
		System.out.println("isHasPrev : " + pageMaker.isHasPrev());
		System.out.println("isHasNext : " + pageMaker.isHasNext());
		
		request.setAttribute("pageMaker", pageMaker);
		// 댓글 수 전송
		dispatcher.forward(request, response); // 포워드로 보내고, list.jsp에서 꺼내써봐
		} else {
			PrintWriter out = response.getWriter();
			out.print("<head><meta charset='UTF-8'></head>");
			out.print("<script>alert('no exist')</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}
	}//end list()
	
	// roll.1 : call register.jsp == insert
	// roll.2 : 글작성 버튼 클릭 -> 로그인 ? no -> login.go -> success? -> register.do
	// fail? -> login.go
	// 로그인 ? yes -> register.do 
	private void registerGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 관련 추가내역. 로그인 세션 검사하고
		HttpSession session = request.getSession();
		String memberIdSession = (String) session.getAttribute("memberId");
		
		if(memberIdSession != null) { // memberId 세션이 존재(로그인 상태) 글 작성 페이지
			
			String path = BOARD_URL + REGISTER + EXTENSION; // WEB_INF/board/register.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else { // memberId 세션이 존재하지 않음(로그아웃 상태)
			// session에 target url 정보를 저장
			session.setAttribute("targetURL", REGISTER + SERVER_EXTENSION); // kk, login.do' loginPOST로 ㄱㄱ
			PrintWriter out = response.getWriter();
			out.print("<head><meta charset='UTF-8'></head>");
			out.print("<script>alert('로그인 후 글작성 가능합니다')</script>");
			// get방식으로 로그인 페이지 호출
			out.print("<script>location.href='login.go';</script>"); 						
			//response.sendRedirect("login.go");			
		}		
	}//end registerGET
	
	// == insert (2) register.jsp 등록정보 -> DB insert, alert -> index.jsp
	private void registerPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = request.getParameter("memberId");
		
		BoardVO vo = new BoardVO(0, boardTitle, boardContent, memberId, null);
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println("result : " + result);
		// 등록되면 메인 index.jsp 보내야지... 
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('success, 축하');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");			
		}			
	}//end registerPOST
	
	// boardId 번호에 맞는 게시글 데이터를 DB에서 선택, (3)
	// 선택된 데이터를 detail.jsp에 전송
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
		System.out.println(vo);
		if(vo != null) {
		request.setAttribute("vo", vo);
		String path = BOARD_URL + DETAIL + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<head><meta charset='UTF-8'></head>");
			out.print("<script>alert('존재하지 않는 게시글 입니다')</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}
	}//end detail()

	// boardId 번호에 맞는 게시글 데이터를 DB에서 선택하여 update.jsp 페이지로 전송 (4)
	private void updateGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
		if(vo != null) {
		request.setAttribute("vo", vo);
		String path = BOARD_URL + UPDATE + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<head><meta charset='UTF-8'></head>");
			out.print("<script>alert('존재하지 않는 게시글 입니다')</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}
	}//end updateGET
		
	// 전송된 DT를 DB에 전송하여 수정하고, detail.jsp 페이지로 이동 5
	private void updatePOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		BoardVO vo = new BoardVO(boardId, boardTitle, boardContent, null, null);
		int result = dao.update(vo);
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('update, 축하');</script>");
			// detail.do?boardId=게시글번호
			out.print("<script>location.href='" + DETAIL + SERVER_EXTENSION + "?boardId="+ boardId +"';</script>");
		}
		
	}//end updatePOST
		
	// 전송된 boardId 번호로 DB에서 데이터 삭제 후 index.jsp페이지로 이동 (6)
	private void deletePOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 존재하는 번호로 접근할 수 밖에 없다.
		int boardId = Integer.parseInt(request.getParameter("boardId"));		
		int result = dao.delete(boardId);
		System.out.println("delete = : " + result);
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('delete, 축하');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");		
		}		
	}//end delete
	
}//end BoardController
