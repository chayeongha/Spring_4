package com.cyh.s4.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyh.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {

	//1.
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="noticeFilesMapper.";
	
	
	public int fileWrite(NoticeFilesVO noticeFilesVO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"fileWrite", noticeFilesVO);
		
	}
}
