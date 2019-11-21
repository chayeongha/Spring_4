package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardQnaVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.model.NoticeFilesVO;
import com.cyh.s4.model.QnaFilesVO;
import com.cyh.s4.service.BoardQnaService;
import com.cyh.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;
	
	
	@GetMapping(value = "fileDown")
	public ModelAndView fileDown(QnaFilesVO qnaFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		qnaFilesVO = boardQnaService.fileSelect(qnaFilesVO);
		mv.addObject("file", qnaFilesVO);
		mv.addObject("board", "qna");
		mv.setViewName("fileDown");
		return mv;
	}
	
	
	
	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(QnaFilesVO qnaFilesVO)throws Exception{
		//System.out.println(noticeFilesVO.getFnum()); 콘솔에 잘나오는지 확인.
		ModelAndView mv = new ModelAndView();
			
		int result=boardQnaService.fileDelete(qnaFilesVO);
		
		//view resolver에서 맨앞에 WEB-INF/views까지 붙여주고 ,맨뒤에 확장자.jsp붙여줌
		mv.addObject("result", result);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
		

	}	
	

	//REPLY-GETMETHOD
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView boardReply(BoardVO boardVO)throws Exception{
	
			ModelAndView mv = new ModelAndView();
		
			mv.addObject("dto", boardVO);
			mv.setViewName("board/boardReply");
		
			return mv;
	}


	//REPLY-POSTMETHOD
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply2(BoardVO boardVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = boardQnaService.boardReply(boardVO);
		
		if(result==1) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg", "Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}



	//LIST
	@RequestMapping(value = "qnaList" ,method= RequestMethod.GET)
	public ModelAndView boardList(Pager pager)throws Exception{
		List<BoardVO> ar = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.setViewName("board/boardList");


		return mv;
	}
	//INSERT-GETMETHOD
	@RequestMapping(value = "qnaWrite" , method = RequestMethod.GET)
	public ModelAndView boardWrite()throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.setViewName("board/boardWrite");

		return mv;
	}

	//INSERT-POSTMETHOD
	@RequestMapping(value = "qnaWrite" , method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO ,HttpSession session ,MultipartFile [] file)throws Exception {

		ModelAndView mv = new ModelAndView();
		
		int result =boardQnaService.boardWrite(boardVO , file , session);
		
		if (result==1) {
			mv.setViewName("redirect:./qnaList");

		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","qnaList");
			mv.setViewName("common/common_result");

		}

		return  mv;
	}


	//SELECT
	@RequestMapping(value= "qnaSelect" ,method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{

		ModelAndView mv= new ModelAndView();

		boardVO= boardQnaService.boardSelect(boardVO);

		boardVO.setContents(boardVO.getContents().replace("\n\r", "<br>"));
		
		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardSelect");

		return mv;


	}



	//UPDATE-GETMETHOD
	@RequestMapping(value = "qnaUpdate" , method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO)throws Exception {

		ModelAndView mv = new ModelAndView();

		boardVO =boardQnaService.boardSelect(boardVO);

		BoardQnaVO qnaVO= (BoardQnaVO)boardVO;
		int size = qnaVO.getFiles().size();
		
		mv.addObject("size", size);
		mv.addObject("dto", boardVO);
		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.setViewName("board/boardUpdate");

		return mv;
	}




	//UPDATE-POSTMETHOD
	@RequestMapping(value = "qnaUpdate",method = RequestMethod.POST )
	public ModelAndView boardUpdate2(BoardVO boardVO, MultipartFile [] file , HttpSession session) throws Exception{

		int result = boardQnaService.boardUpdate(boardVO, file, session);

		ModelAndView mv = new ModelAndView();

		if(result== 1) {
			mv.setViewName("redirect:./qnaList");

		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","qnaList");
			mv.setViewName("common/common_result");


		}
		return mv;
	}

	//DELETE
	@RequestMapping(value="qnaDelete")
	public ModelAndView boardDelete(BoardVO boardVO)throws Exception {
		ModelAndView mv= new ModelAndView();

		int result = boardQnaService.boardDelete(boardVO);

		String msg="FAIL";

		if(result==1) {

			msg="SUCCESS";
		}

		mv.addObject("msg",msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");


		return mv;
	}










}
