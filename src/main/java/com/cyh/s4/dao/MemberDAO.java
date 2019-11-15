package com.cyh.s4.dao;

import com.cyh.s4.model.MemberVO;

public interface MemberDAO {


	
	//JOIN
	public int memberJoin(MemberVO memberVO)throws Exception;	
	
	//LOGIN
	public MemberVO memberLogin(MemberVO memberVO)throws Exception;

	
	//update
	public int memberUpdate(MemberVO memberVO) throws Exception;

	
	//delete
	public int memberDelete(MemberVO memberVO)throws Exception;

	
	//POINT UPDATE
	public int pointUpdate(MemberVO memberVO)throws Exception;

	//IDCHECK
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception;
	
}

