package com.java.ohshu.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

public interface MainDAO {
	
	
	 // 메인 VO 만들어야함

	List<BoardVO> selectAllBoard();

	int seletCountAllBoard();

	List<BoardVO> selectAllBoardByPage(PageMaker pageMaker);

}
