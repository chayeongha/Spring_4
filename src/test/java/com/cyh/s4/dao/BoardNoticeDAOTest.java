package com.cyh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s4.TestAbstractCase;
import com.cyh.s4.model.BoardNoticeVO;
import com.cyh.s4.model.BoardVO;

public class BoardNoticeDAOTest extends TestAbstractCase {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	/* @Test  성공*/
	public void NoticeWriteTest() throws Exception{
	
		BoardVO boardVO = new BoardVO();
	
			
			boardVO.setTitle("forteen1");
			boardVO.setWriter("forteen2");
			boardVO.setContents("forteen3");
			
		int result= boardNoticeDAO.boardWrite(boardVO);
		
		assertNotEquals(1, result);
		
		
	}
	
	/* @Test 성공*/
	public void NoticeDeleteTest()throws Exception {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(10);
		
		int result= boardNoticeDAO.boardDelete(boardVO);
		assertEquals(1, result);
		
		
	}
	
	
	
	
	
}
