package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class IstErstesHalbesjahrTestTest {

	private Util util;
	
	public IstErstesHalbesjahrTestTest() {
		util = new Util();
	}
	

	


	
	@Test
	public void testtrue() {
		for(int i = 1; i <= 6; i++) {
			assertEquals(true, util.istErstesHalbjahr(i));

		}
	}
	
	@Test
	public void testfalse() {
		for(int i = 7; i <= 12; i++) { 
			
			assertEquals(false, util.istErstesHalbjahr(i));
		}
	}
	
	@Test
	public void testauserhalb() {
		try {
			for(int i = 0; i > -2; i--) {
				util.istErstesHalbjahr(i);
			}
			for(int i = 13; i < 15; i++) {
				util.istErstesHalbjahr(i);
			}
		}
		catch(IllegalArgumentException e) {
		
		} }
		
		
		
		
	}


