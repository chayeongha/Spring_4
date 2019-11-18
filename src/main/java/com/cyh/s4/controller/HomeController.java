package com.cyh.s4.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//ajax 예제
	
	@PostMapping(value = "/testAjax")
	public void testAjax(Model model , int num) throws Exception{
		Random r = new Random();
		num= r.nextInt(num); 
		model.addAttribute("num" , num);
	}
	
	
	@GetMapping("/selectAnimal")
	public void selectAnimal(Model model, String kind) throws Exception {
		if(kind.equals("d")) {
			String [] kinds = {"치와와", "푸들", "말티즈"};
			model.addAttribute("kind", kinds);
		}else if(kind.equals("c")) {
			String [] kinds = {"숏컷", "샴", "페르시안"};
			model.addAttribute("kind", kinds);
		}else {
			String [] kinds = {"참새", "앵무새", "비둘기"};
			model.addAttribute("kind", kinds);
		}
	}
	
	
	
	
}
