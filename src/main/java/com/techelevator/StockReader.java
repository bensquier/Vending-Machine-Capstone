package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StockReader {
	
	public Map<String, List<Products>> importFile() throws FileNotFoundException {
		File inputFile = new File("vendingmachine.csv");
		
		
		Map<String, List<Products>> inventory = new TreeMap<>();
		
	try(Scanner fileScanner = new Scanner(inputFile)) {
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] lineSplit = line.split("\\|");
			List<Products> products = new ArrayList<>();
			
			if(line.startsWith("A")) {
				
				
				for(int i = 0; i < 6; i++) {
					
					Chips chip = new Chips(lineSplit[1], new BigDecimal(lineSplit[2]));
					products.add(chip);
					
				}
				
				inventory.put(lineSplit[0], products);
			}
			else if(line.startsWith("B")) {
				
				
				for(int i = 0; i < 6; i++) {
					
					Candy candy = new Candy(lineSplit[1], new BigDecimal(lineSplit[2]));
					products.add(candy);
					
				}
				
				inventory.put(lineSplit[0], products);
			}
			else if(line.startsWith("C")) {
				
				
				for(int i = 0; i < 6; i++) {
					
					Beverages beverage = new Beverages(lineSplit[1], new BigDecimal(lineSplit[2]));
					products.add(beverage);
					
				}
			
				inventory.put(lineSplit[0], products);
			}else {
				
				
				for(int i = 0; i < 6; i++) {
					
					Gum gum = new Gum(lineSplit[1], new BigDecimal(lineSplit[2]));
					products.add(gum);
					
				}
				
				inventory.put(lineSplit[0], products);
			}
		}
		return inventory;
	}
	
	catch(FileNotFoundException e) {
		System.out.println("Your file was now found.");
		System.exit(1);
		return inventory;
	}
	
	}
}




