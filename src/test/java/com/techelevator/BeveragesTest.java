package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BeveragesTest {
	Beverages test;
	
	@Before
	public void setup() {
		
		test = new Beverages("RootBeer", new BigDecimal (2.00));
		
	}
	
	@Test
	public void test() {
		
		assertEquals("RootBeer", test.getBrandName());
		assertEquals(new BigDecimal(2.00), test.getPrice());
		assertEquals("Glug, Glug, Yum!", test.getSound());
		
	}

}
