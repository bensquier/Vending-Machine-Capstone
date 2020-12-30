package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Products{
	
	public Beverages(String brandName, BigDecimal price) {
		super(brandName, price);
	}
	
	
	public String getSound() {
		return "Glug, Glug, Yum!";
	}

	
}
