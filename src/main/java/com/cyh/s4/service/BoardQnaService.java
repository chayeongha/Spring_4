package com.cyh.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cyh.s4.dao.BoardQnaDAO;
import com.cyh.s4.model.BoardQnaVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {

	@Inject
	private BoardQnaDAO boardQnaDAO;


	public int boardReply(BoardVO boardVO) throws Exception{
		
		BoardQnaVO parent = (BoardQnaVO)boardQnaDAO.boardSelect(boardVO);
		
		int result = boardQnaDAO.boardReplyUpdate(parent);

		//방법2,
		parent.setTitle(boardVO.getTitle());
		parent.setWriter(boardVO.getWriter());
		parent.setContents(boardVO.getContents());
		parent.setStep(parent.getStep()+1);
		parent.setDepth(parent.getDepth()+1);
		
		return boardQnaDAO.boardReply(parent);
		
		
		//방법1,
		//		BoardQnaVO child = new BoardQnaVO(); 
		//		child.setTitle(boardVO.getTitle());
		//		child.setWriter(boardVO.getWriter());
		//		child.setContents(boardVO.getContents());
		//		child.setRef(parent.getRef());
		//		child.setStep(parent.getStep()+1); 
		//		child.setDepth(parent.getDepth()+1);
		//		
		//		boardQnaDAO.boardReplyUpdate(child);
		//		
		//		return boardQnaDAO.boardReply(child);


	}




	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {

		// 비지니스 레이어계층
		// 몇개꺼내올껀지.
		pager.makeRow();
		// 꺼내온걸뿌리는.
		pager.makePage(boardQnaDAO.boardCount(pager));

		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {

		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {

		
		
		
		return boardQnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {

		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {

		return boardQnaDAO.boardDelete(boardVO);
	}

}
