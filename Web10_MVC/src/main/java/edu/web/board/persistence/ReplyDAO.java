package edu.web.board.persistence;

import java.util.List;

import edu.web.board.domain.ReplyVO;

public interface ReplyDAO {

	// 
	int insert(ReplyVO vo);
	
	//
	List<ReplyVO> select(int boardId);
	
	//
	int update(ReplyVO vo );
	
	//
	int delete(int replyId);
	
	
}
