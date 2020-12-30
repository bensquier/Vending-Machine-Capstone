package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import org.junit.Test;

public class StockReaderTest {
	
	StockReader test;
	
	
	@Test
	public void test() throws FileNotFoundException {
		
		test = new StockReader();
		Map<String, List<Products>> mapTest = test.importFile();
		Products product1 = mapTest.get("A1").get(0);
		assertEquals("Potato Crisps", product1.getBrandName());
		assertEquals(new BigDecimal("3.05"), product1.getPrice());
		assertEquals(true, mapTest.containsKey("A1"));
		
	}
	
	

}
