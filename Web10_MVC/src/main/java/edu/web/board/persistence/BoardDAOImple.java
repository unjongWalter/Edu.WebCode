package edu.web.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.board.util.PageCriteria;
import edu.web.dbcp.connmgr.ConnMgr;

public class BoardDAOImple implements BoardDAO, BoardQuery{

	private static BoardDAOImple instance = null;	
	private BoardDAOImple() {}	
	public static BoardDAOImple getInstance() {
		if(instance == null) {
			instance = new BoardDAOImple();
		}
		return instance;
	}
	
	@Override
	public int insert(BoardVO vo) {		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			conn = ConnMgr.getConnection(); // 신기방기
			
			// 묶기. 트캐 			
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getMemberId());
			
			result = pstmt.executeUpdate();	
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt); // 갖다써 멋진놈			
		}				
		return result;
	}//end insert
	
	@Override//kk
	public List<BoardVO> select() {
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnMgr.getConnection(); // conn 넣기 전 캐치문 예외 빨갱이임. 
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs  = pstmt.executeQuery();
			
			// while 안할구야(한 그릇 돌려쓰기 ㄴㄴ)
			// 속도 차이 : 새로이 ㄱㄱ
			int boardId;
			String boardTitle;
			String boardContent;
			String memberId;
			Date boardDateCreated;
			BoardVO vo = null;

			while (rs.next()) {
				boardId = rs.getInt(COL_BOARD_ID);
				boardTitle = rs.getString(COL_BOARD_TITLE);
				boardContent = rs.getString(COL_BOARD_CONTENT);
				memberId = rs.getString(COL_MEMBER_ID);
				boardDateCreated = rs.getTimestamp(COL_BOARD_DATE_CREATED);
				vo = new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
				list.add(vo);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		} finally {
			ConnMgr.close(conn, pstmt, rs); // 갖다써 멋진놈			
		}			
		return list;
	}//end list(boardvo) select

	@Override // detail, updateget
	public BoardVO select(int boardId) {		
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_BOARD_ID); // 이까지 ㄱ
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			
			String boardTitle;
			String boardContent;
			String memberId;
			Date boardDateCreated;
			
			if(rs.next()) { // 아뒤는 입력과 돌림이 같아서 개무시떄림
				boardTitle = rs.getString(COL_BOARD_TITLE);
				boardContent = rs.getString(COL_BOARD_CONTENT);
				memberId = rs.getString(COL_MEMBER_ID);
				boardDateCreated = rs.getTimestamp(COL_BOARD_DATE_CREATED);
				vo = new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs); // 갖다써 멋진놈		
		}				
		return vo;
	}

	@Override// pstmt.setInt getBoardId check... memberId?
	public int update(BoardVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_BOARD_ID); // 이까지 ㄱ
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setInt(3, vo.getBoardId());
						
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage()); // log
		} finally {
			ConnMgr.close(conn, pstmt); // 갖다써 멋진놈		
		}				
		return result;
	}//end update

	@Override
	public int delete(int boardId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {			
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE_BY_BOARD_ID); // 이까지 ㄱ
			pstmt.setInt(1, boardId);
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnMgr.close(conn, pstmt); // 갖다써 멋진놈		
		}			
		return result;
	}//end delete
		
	// for the pagescope
	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnMgr.getConnection(); // conn 넣기 전 캐치문 예외 빨갱이임. 			
			pstmt = conn.prepareStatement(SQL_SELECT_PAGESCOPE);
				
			// questionmarks 2... from Pagecriteria.java.method
			
			pstmt.setInt(1, criteria.getStart());
			pstmt.setInt(2, criteria.getEnd());
						
			rs  = pstmt.executeQuery();
						
			int boardId;
			String boardTitle;
			String boardContent;
			String memberId;
			Date boardDateCreated;
			BoardVO vo = null;

			while (rs.next()) {
				boardId = rs.getInt(COL_BOARD_ID);
				boardTitle = rs.getString(COL_BOARD_TITLE);
				boardContent = rs.getString(COL_BOARD_CONTENT);
				memberId = rs.getString(COL_MEMBER_ID);
				boardDateCreated = rs.getTimestamp(COL_BOARD_DATE_CREATED);
				vo = new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
				list.add(vo);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		} finally {
			ConnMgr.close(conn, pstmt, rs); // 갖다써 멋진놈			
		}			
		return list;
	}

	@Override
	public int getTotalCounts() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_TOTAL_CNT);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_cnt");				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}				
		return count;			
	}//end getTotalCounts

}//end DAOImple
