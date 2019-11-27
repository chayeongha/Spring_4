package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardVO;
import com.cyh.s4.service.BoardNoticeService;
import com.cyh.s4.util.Pager;


//모든 메서드가 responsebody컨트롤러를 포함하고있다면  @restController 어노테이션을 사용하자.
@RestController
public class JasonController {
		
		@Inject
		private BoardNoticeService boardNoticeService;
	
		@GetMapping(value = "/getJson1")
		public ModelAndView getJason() throws Exception{
			
			//name=iu , age=27
			String jmsg= "{\"name\":\"iu\" , \"age\":27}";
			System.out.println(jmsg);
			
			ModelAndView mv= new ModelAndView();
			
			mv.addObject("result", jmsg);
			mv.setViewName("common/common_ajaxResult");
			
			return mv;
		}
		
		
		@GetMapping(value = "/getJson2")
		//리턴되는 BoardVO타입값을 리스폰스담아 바로 보내라.
		@ResponseBody
		public BoardVO getJson2(BoardVO boardVO)throws Exception {
			
			//ModelAndView mv = new ModelAndView();
			
			boardVO=boardNoticeService.boardSelect(boardVO);
			
			//boardVO에있는 WRITE, TITLE , CONTENTS를 앨럿창으로 띄어보자
			//문자열과 데이터를 붙여주려면 +해준다.
			//String jmsg= "{\"title\": \""+boardVO.getTitle()+"\", \"writer\": \""+boardVO.getWriter()+"\", \"contents\":\""+boardVO.getContents()+"\"}";
			
		
			
			//mv.addObject("result", jmsg);
			//mv.setViewName("common/common_ajaxResult");
			
			//return mv;
			
			//**제이슨사용
			return boardVO;
		}
		
		
		@GetMapping("/getJson3")
		@ResponseBody
		public List<BoardVO> getJason3(Pager pager) throws Exception{
			//배열일땐
			
			
			return boardNoticeService.boardList(pager);
						
			
		}
		
		
	
		
}
