package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardVO;
import com.cyh.s4.service.BoardNoticeService;
import com.cyh.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
		@Inject
		private BoardNoticeService boardNoticeService;
		@RequestMapping("noticeList")
		public ModelAndView boardList(Pager pager) throws Exception{
			
		     List<BoardVO>  ar =	boardNoticeService.boardList(pager);
		     
		     ModelAndView mv= new ModelAndView();
		     mv.addObject("pager", pager);
		     mv.addObject("list", ar);
		     mv.setViewName("board/boardList");
		     
		     return mv;
		}
}
