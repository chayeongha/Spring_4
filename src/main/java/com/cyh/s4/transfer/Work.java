package com.cyh.s4.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {
			
			@Inject
			private Transfer transfer;
	
			public void goTaxi() {
				transfer.getTaxi();
			}
			
			public void goWork() {
				transfer.getBus("samsung");
				transfer.getSubWay("kakao");
				
			}
			
			
		
}
