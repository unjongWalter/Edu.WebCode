package edu.web.member;

public interface DBConnectionQuery {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB table column 
	public static final String TABLE_NAME = "TEST_MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE ="INTRODUCE";


	// 가입 ㄱ 7(?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	// 검색하자
	public static final String SQL_SELECT_BY_USERID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";
	
	// 수정해라
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME + " SET "+
					COL_PASSWORD + " = ?, "+
					COL_EMAIL + " = ?, "+
					COL_EMAIL_AGREE + " = ?, "+
					COL_INTEREST + " = ?, "+
					COL_PHONE + " = ?, "+
					COL_INTRODUCE + " = ? "+			
			" WHERE "+ COL_USERID + " = ?"; // where 접근해서 뭔가 한다
	
	// 삭제할까
	public static final String SQL_DELETE =
			"DELETE " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";	
	
	// 로그인 허가하노라
	public static final String SQL_LOGIN = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?" + " AND " + COL_PASSWORD + " = ?";
	
} //end ~
