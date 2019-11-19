package com.cyh.s4.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cyh.s4.dao.BoardNoticeDAO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.util.FileSaver;
import com.cyh.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		
		return boardNoticeDAO.boardList(pager); 
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO , HttpSession session) throws Exception {
		
		//1. 파일을 저장할 실제경로
		String realPath = session.getServletContext().getRealPath("classes/resources/upload/board");
		
		
		
		File file = new File(realPath);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		
		//System.out.println(file.exists());//파일이 존재합니까? true
		//System.out.println(file.isDirectory()); //폴더가 존재합니까? 트루면 존재 펄스면 존재x  true
		
		FileSaver fs= new FileSaver();
		
		String fileName = fs.save(realPath, boardVO.getFileName());
		
		boardVO.setFileName(fileName);
		boardVO.setOriginalName(boardVO.get);
		
		
		
		
		
		return boardNoticeDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
