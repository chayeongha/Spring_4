package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardQnaVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.service.BoardQnaService;
import com.cyh.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;

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
	public ModelAndView boardWrite(BoardVO boardVO)throws Exception {

		int result = boardQnaService.boardWrite(boardVO);

		ModelAndView mv = new ModelAndView();


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

		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardSelect");

		return mv;


	}



	//UPDATE-GETMETHOD
	@RequestMapping(value = "qnaUpdate" , method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO)throws Exception {

		boardVO =boardQnaService.boardSelect(boardVO);

		ModelAndView mv = new ModelAndView();

		mv.addObject("dto", boardVO);

		mv.addObject("board", "qna");
		mv.addObject("PageName", "Qna");
		mv.setViewName("board/boardUpdate");

		return mv;
	}




	//UPDATE-POSTMETHOD
	@RequestMapping(value = "qnaUpdate",method = RequestMethod.POST )
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception{

		int result = boardQnaService.boardUpdate(boardVO);

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
