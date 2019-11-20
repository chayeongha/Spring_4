package com.cyh.s4.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.s4.dao.BoardNoticeDAO;
import com.cyh.s4.dao.NoticeFilesDAO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.model.NoticeFilesVO;
import com.cyh.s4.util.FileSaver;
import com.cyh.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	
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
	public int boardWrite(BoardVO boardVO , MultipartFile [] file , HttpSession session) throws Exception {
		
		//1. 파일을 저장할 실제경로
		String realPath = session.getServletContext().getRealPath("resources/upload/member");
		
		
	
		//System.out.println(file.exists());//파일이 존재합니까? true
		//System.out.println(file.isDirectory()); //폴더가 존재합니까? 트루면 존재 펄스면 존재x  true
		
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		System.out.println(boardVO.getNum());
		
//		for(MultipartFile multipartFile:file) {
//			
//			String fileName = fileSaver.save(realPath, multipartFile);
//			noticeFilesVO.setFname(fileName);
//			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
//			noticeFilesDAO.fileWrite(noticeFilesVO);
//			
//		}
//		boardVO.setFileName(fileName);	
//		boardVO.setOriginalName(boardVO.getFile().getOriginalFilename());
//		System.out.println(realPath);
//		System.out.println(fileName);

		return result;
		
	
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
