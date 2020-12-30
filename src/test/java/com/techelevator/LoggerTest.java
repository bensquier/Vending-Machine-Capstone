package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoggerTest {
	
	Logger test = new Logger();
	Scanner scanner = new Scanner("./log.txt");
	
	@Before
	public void setup () {
		
		test.writer("FEED MONEY", new BigDecimal (1.00), new BigDecimal (6.00));
		
	}
	
	@Test (expected=FileNotFoundException.class)
	public void test() {
		
		assertEquals(true, scanner.hasNextLine());
		scanner.nextLine();
		assertEquals(false, scanner.hasNextLine());
		
	}
	
	//@Test
	//public void exceptionTest() {
		
	
	//}
	
	
}
