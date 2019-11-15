package com.cyh.s4.dao;

import javax.inject.Inject;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyh.s4.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="memberMapper.";
		
	//IDCHECK
	public MemberVO memberIDCheck(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", memberVO);
		
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"memberJoin", memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}

	@Override // 개인정보수정
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override //개인정보 삭제
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override	
	public int pointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
