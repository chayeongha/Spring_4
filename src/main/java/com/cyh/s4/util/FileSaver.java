package com.cyh.s4.util;

import java.io.File;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

		//3.io stream 사용
		public String save3(String realPath, MultipartFile  multipartFile)throws Exception{
		
			//*공통적으로 쓰임.
			File file = new File(realPath);
			//System.out.println(file.exists());//파일이존재합니까? 트루면 존재 펄스면 존재x
			
			//파일이 존재한다면 파일의 경로대로 폴더를 만든다.
			if(!file.exists()){
			file.mkdirs();
			}
			//
			
			//저장될 파일명은 중복이 되면안됨(가입하는유저를 이걸로 구분하기때분)
			//STRING타입이필요함으로 스트링타입으로 변경
			String fileName =UUID.randomUUID().toString();
			
			//확장자명을 붙여준다.
			fileName = fileName+"_"+multipartFile.getOriginalFilename();
			
			//연결
			file =new File(realPath, fileName);
			
			FileOutputStream fo = new FileOutputStream(file);
			
			//파일저장.
			fo.write(multipartFile.getBytes());
			fo.close();
			
			return fileName;
			
		}
	
	
	
		//2. MultipartFile transferTo  메서드사용
		public String save (String realPath, MultipartFile  multipartFile)throws Exception{
			//*공통적으로 쓰임.
			File file = new File(realPath);
			//System.out.println(file.exists());//파일이존재합니까? 트루면 존재 펄스면 존재x
			
			System.out.println(realPath);
			//파일이 존재하지않는다면 파일의 경로대로 폴더를 만든다.
			if(!file.exists()){
			file.mkdirs();
			}
			//
			
			//저장될 파일명은 중복이 되면안됨(가입하는유저를 이걸로 구분하기때분)
			//STRING타입이필요함으로 스트링타입으로 변경
			String fileName =UUID.randomUUID().toString();
			
			//확장자명을 붙여준다.
			fileName = fileName+"_"+multipartFile.getOriginalFilename();
			
			//System.out.println(fileName);
			//여기까지 경로명과 파일명 준비가 됨.
			
			//이젠 하드디스크 저장
			file = new File(realPath, fileName);//경로 파일명 담아서 
			multipartFile.transferTo(file);//저장
			
			return fileName;
			
			
		}
	
	
		//1. Spring에서 제공하는 fileCopyUtils  클래스의 copy메서드 사용
		//메서드만들어서저장
		public String save2(String realPath, MultipartFile  multipartFile)throws Exception {
			File file = new File(realPath);
			//System.out.println(file.exists());//파일이존재합니까? 트루면 존재 펄스면 존재x
			
			//파일이 존재한다면 파일의 경로대로 폴더를 만든다.
			if(!file.exists()){
			file.mkdirs();
			}
			
			Calendar ca = Calendar.getInstance();//시,분,초 
			Long name	= ca.getTimeInMillis();//현재시간을 밀리세컨즈로 바꿔줌 롱타입으로
		    
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			
			String fileName	= name+ multipartFile.getOriginalFilename().substring(index);
		  
		
			
			file = new File(realPath, fileName);
			
			System.out.println(fileName);
			FileCopyUtils.copy(multipartFile.getBytes(), file);
			
			return fileName;
		}

}
