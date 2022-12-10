package edu.web.jsp01;

public class TestBean {

	public TestBean() {
		System.out.println("TestBean 생성자 항시발동!!!");
	}

	private String msg = "JSP useBean Test From TestBean";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	private String msg2 = "Test of test";

	public String getMsg2() {
		return msg2;
	}

	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}

}
