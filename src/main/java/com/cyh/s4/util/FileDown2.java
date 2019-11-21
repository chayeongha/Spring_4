package com.cyh.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


import com.cyh.s4.model.QnaFilesVO;

@Component
public class FileDown2 extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		QnaFilesVO qnaFilesVO = (QnaFilesVO)model.get("file");
		String board = (String)model.get("board");
		
//		System.out.println(qnaFilesVO.getFname());
		//		System.out.println(qnaFilesVO.getOname());
		//		System.out.println(board);
		
		String realPath	= request.getSession().getServletContext().getRealPath("resources/upload/"+board);
		
		System.out.println(realPath);
		
		File file = new File(realPath , qnaFilesVO.getFname());
		
		// 한글처리
		response.setCharacterEncoding("UTF-8");
		
		// 파일의 크기
		response.setContentLength((int)file.length());
		
		// 다운로드시 파일 이름 인코딩
		String fileName = URLEncoder.encode(qnaFilesVO.getOname(), "UTF-8");
		
		
		//header설정
		response.setHeader("Content-disposition", "attachment;filename=\" "+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");//바이너리파일
		
		//outputstream으로 연결 (보내는작업)
		FileInputStream fi = new FileInputStream(file);//어느경로에 어느 파일을 가져올지 알아야되므로 file넣어줌.
				
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		// 스트림연결은 무조건 클로즈 (역순)
		os.close();
		fi.close();
				
				
	}

		
	
	
}
