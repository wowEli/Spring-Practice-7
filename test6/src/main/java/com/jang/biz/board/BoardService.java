package com.jang.biz.board;

import java.util.ArrayList;

public interface BoardService {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO selectOneBoard(BoardVO vo);
	ArrayList<BoardVO> selectAllBoard(BoardVO vo);
}
