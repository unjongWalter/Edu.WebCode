package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;
// 5번

public class MemberDAOImple implements MemberDAO, DBConnectionQuery {

	// singleton
	private static MemberDAOImple instance = null;

	private MemberDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());// lib 등록안하면 오류난데이.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end MemberDAOImple()

	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}//end getInstance()

	@Override // 회원 가입
	public int insert(MemberVO vo) {		
		int result = 0; // 결과를 내기위해 그릇 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("oracle connection success");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());

			result = pstmt.executeUpdate();
		}
		// catch (SQLIntegrityConstraintViolationException idpk) {
		//	idpk.printStackTrace();
		//	result = -1;
		// } 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override // 정보보여주노라
	public MemberVO select(String userid) {	
		
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("oracle connect success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);			
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userid = rs.getString(COL_USERID);//getString(String columnlable이 안전빵, int columnindex는 덜안전)
				String password = rs.getString(COL_PASSWORD);
				String email = rs.getString(COL_EMAIL);
				String emailAgree = rs.getString(COL_EMAIL_AGREE);
	
				//about  interest 
				String[] interest = null;
				if(!rs.getString(COL_INTEREST).equals("없냐?")){
					interest = rs.getString(COL_INTEREST).split(",");
				} 
								
				// 인터레스트 배열 값 자체를 하나의 뭉텅이로 봐
				// String[] interest = {rs.getString(COL_INTEREST)};
				// interest 배열에 관련하여 생각많이해봐라. 넣을 때 배열로 넣었으니-꺼낼 때 잘라서 가져와라.
				
				String phone = rs.getString(COL_PHONE);
				String introduce = rs.getString(COL_INTRODUCE);
		
				// vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
				vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}	
		return vo;
	}	
	
	@Override // 수정을 허하노라
	public int update(MemberVO vo) {

		int result = 0; // 그릇 초기화 필수
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			System.out.println("oracle connect success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			// 여기 단디봐라, 주로 오류난다.
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, vo.getUserid()); // 이 순서 기억해라.
						
			result = pstmt.executeUpdate(); 
			
			System.out.println(result + "데이터가 변경 ㄱ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // 0이면 실패 1이면 저장성공
	}// end update

	@Override // 탈퇴
	public int delete(String userid) {
		
		// DB 연결 -> 인덱스 데이터 삭제
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				
				System.out.println("oracle connect success");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pstmt = conn.prepareStatement(SQL_DELETE);
				pstmt.setString(1, userid); // 변경

				result = pstmt.executeUpdate();
				System.out.println(result + "ㅌㅌ");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result; // 0이면 실패 1이면 저장성공
		}// end delete
		
	
	@Override // 로긴로긴, MemberVO로 하면 아이디 오류난대, String으로 바꿔봐라
	public MemberVO login(String userid, String password) {
		
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 그릇 준비 
//		String id = null;
//		String pw = null;
		
		try {
			
			System.out.println("oracle connect success");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_LOGIN);			
			
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userid = rs.getString(COL_USERID);
				password = rs.getString(COL_PASSWORD);
		
				vo = new MemberVO(userid, password);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}	
		return vo;
	}
}
