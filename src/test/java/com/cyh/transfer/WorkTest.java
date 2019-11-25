package com.cyh.transfer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s4.TestAbstractCase;
import com.cyh.s4.transfer.Work;

public class WorkTest extends TestAbstractCase {

	@Inject
	private Work work;
	
	@Test
	public void test() {
		work.goWork();
		
		
	}

}
