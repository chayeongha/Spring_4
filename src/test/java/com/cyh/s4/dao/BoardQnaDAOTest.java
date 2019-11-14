package com.cyh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s4.TestAbstractCase;
import com.cyh.s4.model.BoardQnaVO;
import com.cyh.s4.model.BoardVO;

public class BoardQnaDAOTest extends TestAbstractCase{

	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	/* @Test 성공*/
	public void qnaSelectTest()throws Exception {
		BoardVO boardVO = new BoardVO();			
		 boardVO.setNum(281);
		 
		 boardVO=boardQnaDAO.boardSelect(boardVO);
		 
		assertNotNull(boardVO);
	
		
	}
	
	/* @Test 성공*/
	public void qnaUpdateTest() throws Exception{
		BoardVO boardVO =new BoardVO();
		
		boardVO.setTitle("df");
		boardVO.setWriter("df1");
		boardVO.setContents("dafsf");
		boardVO.setNum(267);
		
		int result =  boardQnaDAO.boardUpdate(boardVO);
		
		assertEquals(1, result);
	}
	
	/* @Test 성공*/
	public void QnaDeleteTest()throws Exception {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(11);
		
		int result= boardQnaDAO.boardDelete(boardVO);
		assertEquals(1, result);
		
		
	}
	
	
}
