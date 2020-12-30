package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Products{
	
	
	
	public Chips(String brandName, BigDecimal price) {
		super(brandName, price);
	}
	
	
	public String getSound() {
		return "Crunch, Crunch, Yum!";
	}

	


	
	

}
