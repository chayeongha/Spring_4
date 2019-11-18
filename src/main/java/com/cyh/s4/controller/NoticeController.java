package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardVO;
import com.cyh.s4.service.BoardNoticeService;
import com.cyh.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	//ajax예제
	@GetMapping(value = "noticeResult")
	public String noticeResult(Pager pager , Model model)throws Exception {
		
	pager.setPerPage(5);//원래 10이엇는데 5개만받기위해서 5로 셋팅해줌.
		
	List<BoardVO>ar= boardNoticeService.boardList(pager);
	System.out.println(ar.size());
	
	model.addAttribute("list", ar);
	
	return "board/noticeResult";
	}
	
	
	
	
	@RequestMapping(value = "noticeSelect" , method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO)throws Exception {
		
		
		ModelAndView mv= new ModelAndView();
		
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		mv.addObject("board", "notice");
		mv.addObject("PageName", "Notice");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="noticeList", method= RequestMethod.GET)
	public ModelAndView boardList(Pager pager) throws Exception{
		
		List<BoardVO> ar= boardNoticeService.boardList(pager);
		ModelAndView mv =new ModelAndView();
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board","notice");
		mv.addObject("PageName", "Notice");
		mv.setViewName("board/boardList");
		return mv;
		
	}

	@RequestMapping(value = "noticeWrite" ,method = RequestMethod.GET)
	public ModelAndView  boardWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("board","notice");
		mv.addObject("PageName", "Notice");
		mv.setViewName("board/boardWrite");
	
		return mv;
		
	}
	
	
	
	@RequestMapping(value = "noticeWrite" , method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception{
		
		int result =boardNoticeService.boardWrite(boardVO);
		
		ModelAndView  mv = new ModelAndView();
		
	
		if (result==1) {
			mv.setViewName("redirect:./noticeList");
			
		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","noticeList");
			mv.setViewName("common/common_result");
			
		}
		
		return mv;
		
	}
	
	//update
	@RequestMapping(value = "noticeUpdate" , method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception{
		
	boardVO	= boardNoticeService.boardSelect(boardVO);
		
	ModelAndView mv =new ModelAndView();
	
	mv.addObject("dto", boardVO);
	
	mv.addObject("board", "notice");
	mv.addObject("PageName", "Notice");
	mv.setViewName("board/boardUpdate");
	
	return mv;
	
	}
	
	@RequestMapping(value ="noticeUpdate",method = RequestMethod.POST )
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception{
		
int result =boardNoticeService.boardUpdate(boardVO);
		
		ModelAndView mv = new ModelAndView();
		
		if(result== 1) {
			mv.setViewName("redirect:./noticeList");
			
		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","noticeList");
			mv.setViewName("common/common_result");
			
		}
		return mv;
		
		
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO)throws Exception {
		
		int result = boardNoticeService.boardDelete(boardVO);
		
		ModelAndView mv =new ModelAndView();
		
		if(result== 1) {
			mv.addObject("msg","Success");
			mv.addObject("path","noticeList");
			mv.setViewName("common/common_result");
			
		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","noticeList");
			mv.setViewName("common/common_result");
			
		}
		return mv;
		
		
	}
	
}
