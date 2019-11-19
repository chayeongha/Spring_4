package com.cyh.s4.service;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cyh.s4.dao.MemberDAOImpl;
import com.cyh.s4.model.MemberVO;
import com.cyh.s4.util.FileSaver;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	@Override
	public MemberVO memberIdCheck(MemberVO memberVO)throws Exception{
		
		return memberDAOImpl.memberIDCheck(memberVO);
	}
	
	@Override
	public int memberJoin(MemberVO memberVO , HttpSession session) throws Exception {
		//server hdd에 파일 저장.
		//1. 파일을 저장할 실제경로
		String realPath = session.getServletContext().getRealPath("resources/upload/member");
		
		File file = new File(realPath);
		//System.out.println(file.exists());//파일이존재합니까? 트루면 존재 펄스면 존재x
		
		//파일이 존재한다면 파일의 경로대로 폴더를 만든다.
		if(!file.exists()){
		file.mkdirs();
		}
		//System.out.println(file.exists());
		//System.out.println(file.isDirectory());
		FileSaver fs= new FileSaver();
		
		String fileName=fs.save3(realPath, memberVO.getFile());
			
		memberVO.setFileName(fileName);
		memberVO.setOriginalName(memberVO.getFile().getOriginalFilename());
		
		return memberDAOImpl.memberJoin(memberVO); 
		
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		return memberDAOImpl.memberLogin(memberVO);
	}
	
	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberUpdate(memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		
		
		return memberDAOImpl.memberDelete(memberVO);
	}

	@Override
	public int pointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
