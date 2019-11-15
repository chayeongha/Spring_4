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
		//session.removeAttribute("member");
		session.invalidate();// 유지시간을 0으로 변경.(라이프사이클 )
		
		return "redirect:../";
		
	}
	

	
	
	
}
