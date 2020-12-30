package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
	
	public void writer(String typeOfTransaction, BigDecimal amount, BigDecimal balance) {
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		try(PrintWriter logger = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))){
			
			String printDate = date.toString();
			String printTime = time.toString();
			String printTransactionType = typeOfTransaction.toString();
			String printAmount = amount.toString();
			String printBalance = balance.toString();
			
			logger.println(printDate + " | " + printTime.substring(0, time.toString().length() - 4) + " | " + printTransactionType.substring(0, typeOfTransaction.length()) +  " | $" + printAmount + " | $" + printBalance );
			
			
			
			
			
		} catch (FileNotFoundException e) {
			
			e.getMessage();
		}
	}

}
