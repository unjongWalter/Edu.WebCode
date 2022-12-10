package edu.web.member;

import java.util.Arrays;

public class MemberVO {
	
	// 주의) useBean을 위한 VO를 생성할 경우, parameter name과 변수명이 같아라.
	
	private String userid;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introduce;
	
	// useBean을 사용할 때는 기본생성자를 반드시! 생성~!~!
	public MemberVO() {}
	
	public MemberVO(String userid, String password, String email, String emailAgree, String[] interest, String phone,
			String introduce) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.phone = phone;
		this.introduce = introduce;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userId) {
		this.userid = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailAgree() {
		return emailAgree;
	}
	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}
	
	
	public String[] getInterest() {
		return interest;
	}
	
	
	// DB에는 배열형태가 없기에 쳐넣기위한 수작질(imple에서 대신)
	public String getInterestJoin() { // 삼항 연산자...?
		String result = (interest == null) ? "없냐?" : String.join(",", interest);
		return result;
		
		
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", email=" + email + ", emailAgree="
				+ emailAgree + ", interest=" + Arrays.toString(interest) + ", phone=" + phone + ", introduce="
				+ introduce + "]";
	}
		
}
