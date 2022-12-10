package edu.web.board.domain;

import java.util.Date;

public class ReplyVO {

	private int replyId; // seq로 돌림
	private int boardId;
	private String memberId; // member table
	private String replyContent;
	private Date replyDateCreated; // sysdate
	
	public ReplyVO() {
		super();
	}
	
	public ReplyVO(int replyId, int boardId, String memberId, String replyContent, Date replyDateCreated) {
		super();
		this.replyId = replyId;
		this.boardId = boardId;
		this.memberId = memberId;
		this.replyContent = replyContent;
		this.replyDateCreated = replyDateCreated;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDateCreated() {
		return replyDateCreated;
	}
	public void setReplyDateCreated(Date replyDateCreated) {
		this.replyDateCreated = replyDateCreated;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", boardId=" + boardId + ", memberId=" + memberId + ", replyContent="
				+ replyContent + ", replyDateCreated=" + replyDateCreated + "]";
	}	
	
}
