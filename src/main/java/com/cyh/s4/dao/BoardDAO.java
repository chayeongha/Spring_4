package com.cyh.s4.dao;

import java.util.List;

import com.cyh.s4.model.BoardVO;
import com.cyh.s4.util.Pager;

public interface BoardDAO {
	
	
	//LIST
	public List<BoardVO>boardList(Pager pager) throws Exception;
		
	
	//SELECT 리턴은 int값이므로 int num을 매개변수로.. BoardVO boardVO에도 NUM이 있기때문에 VO로함. (에러도뜰수있기때문에)
	public BoardVO boardSelect(BoardVO boardVO) throws Exception;
	
	//WRITE  매개변수를 title , contents, writer를 받아야되므로 값이 보드vo에있기떄문에 매개변수에넣음.
	public int boardWrite(BoardVO boardVO)throws Exception;
	//UPDATE 마찬가지임.
	public int boardUpdate(BoardVO boardVO)throws Exception;
	//DELETE INT NUM을 받아 지우기때문에  보드브이오에있는 넘값이있는 boardVO를 매개변수로담음
	public int boardDelete(BoardVO boardVO)throws Exception;
	//COUNT  
	public int boardCount(Pager pager)throws Exception;
}
