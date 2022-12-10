package edu.web.board.persistence;

import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.board.util.PageCriteria;

// make based query form
public interface BoardDAO {
	
	// insert, (2)
	int insert(BoardVO vo);
	
	// list 보여주기kk, boardcontroller list method 만들 때, (1)
	List<BoardVO> select();

	// detail, (3)(4)/updateGet에도 사용?
	BoardVO select(int boardId);
	
	// update, (5)
	int update(BoardVO vo);
	
	// delete, (6)
	int delete(int boardId);
	
	// for pagescope....
	List<BoardVO> select(PageCriteria criteria);
	
	// total_cnt
	int getTotalCounts();
	
}
