package com.cyh.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {
			
			@Inject
			private Card card;
			@Inject
			private Bus bus;
			@Inject
			private Subway  subway;
			
			public void goWork() {
				card.cardCheck();
				bus.getBus();
				card.cardCheck();
				card.cardCheck();
				subway.getSubWay();
				card.cardCheck();
			}
			
			
		
}
