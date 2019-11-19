package com.cyh.s4.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	//MultipartFile transferTo  메서드사용
	public String save(String realPath,  MultipartFile multipartFile )throws Exception {
		
		File file = new File(realPath);
		
		//파일 존재한다면 만들어준다.
		if(!file.exists()) {
			file.mkdirs();
			
		}
		
		//스트링타입으로 바꿔준다.
		String fileName = UUID.randomUUID().toString();
		
		//확장자명을 붙여준다.
		
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//test
		System.out.println(fileName);
		
		//하드디스크 저장
		file = new File(realPath , fileName);// 경로 , 파일명 담는다.
		multipartFile.transferTo(file);
		
		
		return fileName;
	}
	
}
