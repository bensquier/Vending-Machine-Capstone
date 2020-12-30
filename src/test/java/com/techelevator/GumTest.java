package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GumTest {
	
	Gum test;
	
	@Before
	public void setup() {
		
		test = new Gum("SpearMint", new BigDecimal (0.75));
		
	}
	
	@Test
	public void test() {
		
		assertEquals("SpearMint", test.getBrandName());
		assertEquals(new BigDecimal(0.75), test.getPrice());
		assertEquals("Chew, Chew, Yum!", test.getSound());
		assertEquals("SpearMint | 0.75", test.toString());
		
	}



}
