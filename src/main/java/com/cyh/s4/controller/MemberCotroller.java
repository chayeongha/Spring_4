package com.cyh.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s4.model.MemberVO;
import com.cyh.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberCotroller {
	
	@Inject
	private MemberServiceImpl memberServiceImpl;
	
	
	//MemberDelete
	@GetMapping(value = "memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO,HttpSession session )throws Exception{
		
		int result = memberServiceImpl.memberDelete(memberVO);
		
		ModelAndView mv = new ModelAndView();
		
		if(result==1) {
			session.removeAttribute("member");
			mv.addObject("msg", "Delete Success");
			mv.addObject("path", "../");
			mv.setViewName("common/common_result");
		}else {
			mv.addObject("msg", "Delete Fail");
			mv.addObject("path", "./memberMypage");
			mv.setViewName("common/common_result");
		}
		return mv;
		
			
	}
	
	//MemberUpdate-GETMETHOD
	@GetMapping(value = "memberUpdate")
	public void memberUpdate() throws Exception {
		
	}
	
	//MemberUpdate-POSTMETHOD
	@PostMapping(value = "memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session)throws Exception{
		
		int result = memberServiceImpl.memberUpdate(memberVO);
		
		ModelAndView mv = new ModelAndView();
		
		if(result==1) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:./memberMypage");
		}else {
			mv.addObject("msg", "Update Fail");
			mv.addObject("path", "./memberMypage");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	
	//MYpage
	@GetMapping(value = "memberMypage")
	public void memberMypage() throws Exception {
	}
	
	
	
	@GetMapping(value = "memberJoin")
	public void memberJoin() throws Exception{
		
		
	}
	
	@PostMapping(value = "memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO)throws Exception {

	int result = memberServiceImpl.memberJoin(memberVO);
	
	ModelAndView mv = new ModelAndView();
	
	String msg ="회원가입 실패";
	if(result==1) {
			msg="성공"	;
			mv.setViewName("redirect:../");
	}
	
	mv.addObject("msg" , msg);
	mv.addObject("path", "../");
	mv.setViewName("common/common_result");
	
	return mv;
	}
	@GetMapping(value = "memberIdCheck")
	public void memberIdCheck(MemberVO memberVO , Model model)throws Exception{
	
				memberVO	  =memberServiceImpl.memberIdCheck(memberVO); 
			
			String msg="중복된 아이디입니다.";
		
			if(memberVO==null) {
				//사용 가능
				msg="사용가능한아이디입니다.";
			}
			model.addAttribute("msg" ,msg);
			model.addAttribute("dto" , memberVO);
		
	}
	
	@GetMapping(value = "memberLogin")
	public void memberLogin()throws Exception {
		
	}
	

	
	
	@PostMapping(value = "memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO ,HttpSession session) throws Exception{
		
	memberVO = memberServiceImpl.memberLogin(memberVO);
		
	ModelAndView mv= new ModelAndView();
	
	String msg= "실패";
	if(memberVO != null) {
		
		session.setAttribute("member", memberVO);
		mv.setViewName("redirect:../");
		
	}else {
	
	mv.addObject("msg" , msg);
	mv.addObject("path", "../");
	mv.setViewName("common/common_result");
	}
	return mv;
	
	//, HttpSession session
	
	/*if(memberVO != null) {
		
		session.setAttribute("member", memberVO);
		
	}*/
		

	}
	
	@GetMapping(value = "memberLogout")
	public String memberLogout(HttpSession session) throws Exception{
				// 1번째 : session의 속성을 없애는 방법
				session.removeAttribute("member");
				
				// 2번째 : session의 시간을 초기화 즉, 0으로 만드는 방법.
				// httpSession.invalidate();
				
				return "redirect:../";
		
	}
	

	
	
	
}
