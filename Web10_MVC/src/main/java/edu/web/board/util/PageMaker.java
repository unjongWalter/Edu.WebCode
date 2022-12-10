package edu.web.board.util;

// 페이지 번호들의 링크를 만들기 위한 유틸리티 클래스
public class PageMaker {
	private PageCriteria criteria;
	private int totalCount; // 전체 게시글 개수
	private int numsOfPageLinks; // 페이지 번호 링크의 개수
	private int startPageNo; // 시작 페이지 링크 번호
	private int endPageNo; // 끝 페이지 링크 번호
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는 지
	private boolean hasNext; // 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	
	// numsOfPageLinks == LinksPerPage
	public PageMaker() {
		this.numsOfPageLinks = 5;
	}
	
	// 매개변수 있는 놈 ㄱ
	public PageMaker(PageCriteria criteria, int totalcount) {
		this.numsOfPageLinks = 5;
		this.criteria = criteria;
		this.totalCount = totalCount;
		setPageData();				
	}
		
	// getter/setter
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	// numsOfPageLinks == LinksPerPage
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 및 세팅
	public void setPageData() {
		// 총 페이지/링크 수
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
		// 
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
		
		if (temp > totalLinkNo) {
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		
		// 현재 페이지의 startPageNo 구하기...
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		
		// 첫 페이지 변호일 때 이전버튼 ㄴㄴ
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		// 마지막 페이지 번호일 때 다음버튼 ㄴㄴ
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// Math.ceil (올림)
		// Math.floor (버림)
		
	}//end setPageData()
	
} // end PageMaker
