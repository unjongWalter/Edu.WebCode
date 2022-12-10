package edu.web.board.persistence;

public interface BoardQuery {	
	
	public static final String TABLE_NAME = "BOARD";
	public static final String COL_BOARD_ID = "BOARD_ID";
	public static final String COL_BOARD_TITLE = "BOARD_TITLE";
	public static final String COL_BOARD_CONTENT = "BOARD_CONTENT";
	public static final String COL_MEMBER_ID = "MEMBER_ID";
	public static final String COL_BOARD_DATE_CREATED = "BOARD_DATE_CREATED";
	
//	public static final String SQL_INSERT = insert into board 
//	values (SEQ_BOARD.nextval, '가나다라마바사아자차', 'test', 'mok', sysdate);
	
	public static final String SQL_INSERT = 
			"insert into " + TABLE_NAME + " values " 
			+ "(SEQ_BOARD.nextval, ?, ?, ?, sysdate)";
	

//	 - 전체 게시글 선택 select * from board order by board_id desc; 내림차순 정렬 쿼리 ㄱ
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + 
			" order by " + COL_BOARD_ID + " desc";
	
//	 - 특정 게시글 선택 select * from board where board_id = 1;
	public static final String SQL_SELECT_BY_BOARD_ID = 
			"SELECT * FROM " + TABLE_NAME + 
			" where " + COL_BOARD_ID + " = ?";

//	 - 특정 게시글 수정 update board set board_title = 'update', board_content = '수정했냐?', board_date_created = sysdate
//	where board_id = 1;
	public static final String SQL_UPDATE_BY_BOARD_ID = 
			"update " + TABLE_NAME + " set " 
			+ COL_BOARD_TITLE + " = ?, "
			+ COL_BOARD_CONTENT + " = ?, "
			+ COL_BOARD_DATE_CREATED + " = sysdate "
			+ "where " + COL_BOARD_ID + " = ?";
	
//	 - 특정 게시글 삭제
// delete from board where board_id = ?
	public static final String SQL_DELETE_BY_BOARD_ID = 
			"delete from " + TABLE_NAME + " where " + COL_BOARD_ID + " = ?";
		
//	 - 게시글 페이징 처리하여 선택
//	select b.board_id, b.board_title, b.board_content, b.member_id, b.board_date_created from (
//		    select rownum rn, a.* from (
//		        select * from board order by board_id desc
//		    )a
//		)b where rn between 1 and 5;
		
	public static final String SQL_SELECT_PAGESCOPE =
			"select b." + COL_BOARD_ID +", b." + COL_BOARD_TITLE + ", b." + COL_BOARD_CONTENT + ", b." 
			+ COL_MEMBER_ID + ", b." + COL_BOARD_DATE_CREATED + " from ("
			+ "select rownum rn, a.* from ("
				+ "select * from " + TABLE_NAME + " order by " + COL_BOARD_ID + " desc"
			+ ")a"
			+ ")b where rn between ? and ?";
		
//	 - 전체 게시글 수 선택
	// select count(*) total_cnt from board;
	public static final String SQL_TOTAL_CNT = 
			"select count(*) total_cnt from " + TABLE_NAME;
			
}//end Query
