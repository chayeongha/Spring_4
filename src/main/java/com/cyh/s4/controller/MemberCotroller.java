package com.cyh.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyh.s4.model.MemberVO;
import com.cyh.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberCotroller {
	
	@Inject
	private MemberServiceImpl memberServiceImpl;
	
	
	@GetMapping(value = "memberJoin")
	public void memberJoin(MemberVO memberVO) throws Exception{
		
		
	}
	
	@PostMapping(value = "memberJoin")
	public void memberJoin()throws Exception {}
	

}
