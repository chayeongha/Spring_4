package com.cyh.s4.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.s4.dao.BoardNoticeDAO;
import com.cyh.s4.dao.NoticeFilesDAO;
import com.cyh.s4.model.BoardNoticeVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.model.NoticeFilesVO;
import com.cyh.s4.util.FileSaver;
import com.cyh.s4.util.Pager;

@Service
@Transactional
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO) throws Exception{
		
		return noticeFilesDAO.fileSelect(noticeFilesVO);
	}
	
	
	
	public int fileDelete(NoticeFilesVO noticeFilesVO)throws Exception {
		
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		
		return boardNoticeDAO.boardList(pager); 
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		
		//리턴은 한개보내야되는데 보내야될게 2개가됨.
		//boardVO=boardNoticeDAO.boardSelect(boardVO);
		
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		
		//List<NoticeFilesVO> ar= noticeFilesDAO.fileList(boardVO.getNum()); 
		
		//boardNoticeVO.setFiles(ar);
		
		return boardNoticeDAO.boardSelect(boardVO);
		
		
		
	}
	
	@Transactional
	@Override
	public int boardWrite(BoardVO boardVO , MultipartFile [] file , HttpSession session) throws Exception {
		
		//1. 파일을 저장할 실제경로
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		//System.out.println(file.exists());//파일이 존재합니까? true
		//System.out.println(file.isDirectory()); //폴더가 존재합니까? 트루면 존재 펄스면 존재x  true
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		
		noticeFilesVO.setNum(boardVO.getNum());
		System.out.println(realPath);
		for(MultipartFile multipartFile:file) {
			if(multipartFile.getSize() != 0) {
			
			String fileName = fileSaver.save(realPath, multipartFile);
			noticeFilesVO.setFnum(boardVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
			result=noticeFilesDAO.fileWrite(noticeFilesVO);
			
			if(result<1) {
			throw 	new SQLException();
			}
			
			}
		}
		

		return result;
		
	
	}
	
	@Transactional
	@Override
	public int boardUpdate(BoardVO boardVO , MultipartFile [] file , HttpSession session) throws Exception {
		
		//1.파일을 저장할 실제 경로
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		noticeFilesVO.setNum(boardVO.getNum());
		
		//경로명test
		System.out.println(realPath);
		
		for(MultipartFile multipartFile:file) {
				String fileName = fileSaver.save(realPath, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
			
				noticeFilesDAO.fileWrite(noticeFilesVO);
		}
		
		return boardNoticeDAO.boardUpdate(boardVO);
		
	
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
