package com.cyh.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class sqlSessionTest extends TestAbstractCase{

	@Inject
	private SqlSession sqlSession;
	
	
	
	@Test
	public void sqltest() {
	   assertNotNull(sqlSession);
	}

	
	@Inject
	private DataSource dataSource;
	
	@Test
	public void dataSourceTest()throws Exception {
		assertNotNull(dataSource.getConnection());
	}
	
}
