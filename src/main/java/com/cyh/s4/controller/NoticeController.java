package com.cyh.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.BoardNoticeVO;
import com.cyh.s4.model.BoardVO;
import com.cyh.s4.model.NoticeFilesVO;
import com.cyh.s4.service.BoardNoticeService;
import com.cyh.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;
	
	/*
	 * @ExceptionHandler(NullPointerException.class) public ModelAndView getNull() {
	 * 
	 * ModelAndView mv= new ModelAndView();
	 * mv.setViewName("common/common_500_error");
	 * 
	 * return mv; }
	 */
	@Value("#{db['notice']}")
	private String board;
	
	@PostMapping(value = "summerFile")
	public ModelAndView summerFile(MultipartFile file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String fileName = boardNoticeService.summerFile(file, session);
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", fileName);
		return mv;

	}
	

	@GetMapping(value= "fileDown")
	public ModelAndView fileDown(NoticeFilesVO noticeFilesVO) throws Exception{
    
		noticeFilesVO =	boardNoticeService.fileSelect(noticeFilesVO);

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("file", noticeFilesVO);
		mv.setViewName("fileDown");
		
		return mv;
	}

	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(NoticeFilesVO noticeFilesVO)throws Exception{
		//System.out.println(noticeFilesVO.getFnum()); 콘솔에 잘나오는지 확인.
		ModelAndView mv = new ModelAndView();
			
		int result=boardNoticeService.fileDelete(noticeFilesVO);
		
		//view resolver에서 맨앞에 WEB-INF/views까지 붙여주고 ,맨뒤에 확장자.jsp붙여줌
		mv.addObject("result", result);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
		

	}	




	@RequestMapping(value = "noticeSelect" , method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO)throws Exception {


		ModelAndView mv= new ModelAndView();

		boardVO = boardNoticeService.boardSelect(boardVO);

		boardVO.setContents(boardVO.getContents().replace("\n\r", "<br>"));
		
		
		mv.addObject("boardVO", boardVO);
	
		mv.addObject("PageName", "Notice");
		
		mv.setViewName("board/boardSelect");

		return mv;

	}



	@RequestMapping(value="noticeList", method= RequestMethod.GET)
	public ModelAndView boardList(Pager pager) throws Exception{

		List<BoardVO> ar= boardNoticeService.boardList(pager);
		System.out.println("??????? : "+ar);
		ModelAndView mv =new ModelAndView();

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		mv.addObject("PageName", "Notice");
		mv.setViewName("board/boardList");
		return mv;

	}

	@RequestMapping(value = "noticeWrite" ,method = RequestMethod.GET)
	public ModelAndView  boardWrite()throws Exception{
		ModelAndView mv = new ModelAndView();

		
		mv.addObject("PageName", "Notice");
		mv.setViewName("board/boardWrite");

		return mv;

	}



	@RequestMapping(value = "noticeWrite" , method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO , MultipartFile [] file ,HttpSession session) throws Exception{

		ModelAndView  mv = new ModelAndView();
		for(int i=0;i<file.length;i++) {

			System.out.println(	file[i].getOriginalFilename());
		}


		int result =boardNoticeService.boardWrite(boardVO , file , session);



		if (result==1) {
			mv.setViewName("redirect:./noticeList");

		}else {
			mv.addObject("msg","FAIL");
			mv.addObject("path","noticeList");
			mv.addObject("boardVO", boardVO);
			mv.setViewName("common/common_result");
		}

		return mv;

	}

	//update
	@RequestMapping(value = "noticeUpdate" , method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception{

		boardVO	= boardNoticeService.boardSelect(boardVO);

		ModelAndView mv =new ModelAndView();
		
		BoardNoticeVO noticeVO = (BoardNoticeVO)boardVO;
		int size = noticeVO.getFiles().size();
		mv.addObject("size", size);
		mv.addObject("PageName","Notice Board");
		mv.addObject("boardVO", boardVO);
		
		mv.setViewName("board/boardUpdate");
		return mv;

	}

	@RequestMapping(value ="noticeUpdate",method = RequestMethod.POST )
	public ModelAndView boardUpdate2(BoardVO boardVO , MultipartFile [] file , HttpSession session) throws Exception{

		int result =boardNoticeService.boardUpdate(boardVO, file , session);

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
