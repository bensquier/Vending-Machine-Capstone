package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CandyTest {
	
	
	Candy test;
	
	@Before
	public void setup() {
		
		test = new Candy("JollyRancher", new BigDecimal (1.25));
		
	}
	
	@Test
	public void test() {
		
		assertEquals("JollyRancher", test.getBrandName());
		assertEquals(new BigDecimal(1.25), test.getPrice());
		assertEquals("Munch, Munch, Yum!", test.getSound());
		
	}



}
