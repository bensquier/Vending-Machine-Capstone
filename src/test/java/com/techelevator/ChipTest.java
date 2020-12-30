package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	
		Chips test;
		
		@Before
		public void setup() {
			
			test = new Chips("PopChips", new BigDecimal (2.50));
			
		}
		
		@Test
		public void test() {
			
			assertEquals("PopChips", test.getBrandName());
			assertEquals(new BigDecimal(2.50), test.getPrice());
			assertEquals("Crunch, Crunch, Yum!", test.getSound());
			
		}


}
