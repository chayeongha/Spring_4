package com.cyh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String encode;
	
	/**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		//필터 객체가 없어질 때 한번 실행하는것
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// request 발생시 실행하는 구간.
		request.setCharacterEncoding(this.encode);
		response.setCharacterEncoding(this.encode);
		System.out.println("FILTER IN");
		
		chain.doFilter(request, response);
		
		System.out.println("FILTER OUT");
		//response 발생시 실행하는 구간.
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// 객체가 생성되고 나서 딱한번 실행 초기화 메서드
		this.encode = fConfig.getInitParameter("encode");
		
		
	}
	
	
}
