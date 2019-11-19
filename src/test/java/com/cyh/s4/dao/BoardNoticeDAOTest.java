package com.cyh.s4.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s4.TestAbstractCase;
import com.cyh.s4.model.BoardNoticeVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.util.Pager;

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
	
	@Test
	public void noticeList() throws Exception{
		BoardVO boardVO = new BoardVO();
		Pager pager = new Pager();
		List<BoardVO> ar = new ArrayList<BoardVO>();
		
		ar = boardNoticeDAO.boardList(pager);
		assertNotNull(ar);
	}
	
	
}
