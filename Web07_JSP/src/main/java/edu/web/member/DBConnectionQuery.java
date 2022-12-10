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

	// insert into TEST_MEMBER values
	// (?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_INSERT = "insert into " + TABLE_NAME +
			" values (?, ?, ?, ?, ?, ?, ?)";
	
} //end ~
