package com.cyh.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void getCar() {
		System.out.println("----MyCar----");
		System.out.println("운전");
		System.out.println("----MyCar----");
	}
	
	public void getTaxi() {
		
		System.out.println("-----taxi-----");
		System.out.println("택시타기");
		System.out.println("-----taxi-----");
	}
	
	
	public void getBus(String cardName) {
		
		System.out.println("------Bus-------");
		System.out.println("음악");
		System.out.println("------Bus-------");	
	}
	
	public void getSubWay(String cardName) {
		
		System.out.println("------SubWay-------");
		System.out.println("음악");
		System.out.println("------SubWay-------");
			}
	
	
}
