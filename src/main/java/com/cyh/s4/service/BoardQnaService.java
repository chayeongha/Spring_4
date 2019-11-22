package com.cyh.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.s4.dao.BoardQnaDAO;
import com.cyh.s4.dao.QnaFilesDAO;
import com.cyh.s4.model.BoardQnaVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.model.FilesVO;

import com.cyh.s4.util.FileSaver;
import com.cyh.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {

	@Inject
	private BoardQnaDAO boardQnaDAO;

	@Inject
	private FileSaver fileSaver;

	@Inject
	private QnaFilesDAO qnaFilesDAO;

public FilesVO fileSelect(FilesVO filesVO) throws Exception{
		
		return qnaFilesDAO.fileSelect(filesVO);
	}



	public int fileDelete(FilesVO filesVO)throws Exception {

		return qnaFilesDAO.fileDelete(filesVO);
	}


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
		//boardVO=boardQnaDAO.boardSelect(boardVO);

		//BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;

		//List<QnaFilesVO> ar= qnaFilesDAO.fileList(boardVO.getNum());

		//boardQnaVO.setFiles(ar);

		return boardQnaDAO.boardSelect(boardVO);

	}

	@Override
	public int boardWrite(BoardVO boardVO , MultipartFile [] file , HttpSession session) throws Exception {

		//1. 파일을 저장할 실제경로
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");

		//System.out.println(file.exists());//파일이 존재합니까? true
		//System.out.println(file.isDirectory()); //폴더가 존재합니까? 트루면 존재 펄스면 존재x  true

		FilesVO filesVO = new FilesVO();
		int result = boardQnaDAO.boardWrite(boardVO);

		System.out.println(realPath);

		for(MultipartFile multipartFile:file) {

			String fileName = fileSaver.save(realPath, multipartFile);
			filesVO.setFname(fileName);
			filesVO.setOname(multipartFile.getOriginalFilename());
			filesVO.setNum(boardVO.getNum());
			qnaFilesDAO.fileWrite(filesVO);

		}

		return result;

	}


	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session ) throws Exception {

		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		FilesVO filesVO = new FilesVO();
		int result = boardQnaDAO.boardUpdate(boardVO);
		for(MultipartFile multipartFile : file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			filesVO.setFname(fileName);
			filesVO.setOname(multipartFile.getOriginalFilename());
			filesVO.setNum(boardVO.getNum());
			qnaFilesDAO.fileWrite(filesVO);
		}

		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {

		return boardQnaDAO.boardDelete(boardVO);
	}






}
