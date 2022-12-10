package edu.web.member;

public interface MemberDAO { // 4번
	
	// 가입
	public abstract int insert(MemberVO vo);
		
	// 수정
	public abstract int update(MemberVO vo);
	
	// 삭제/탈퇴
	public abstract int delete(String userid);
	
	// login, 결과값 비교
	public abstract MemberVO login(String userid, String password);
	
	// select 검색용...?
	public abstract MemberVO select(String userid);

}//end ~
