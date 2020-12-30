package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Products{
	
	public Candy(String brandName, BigDecimal price) {
		super(brandName, price);
	}
	
	
	public String getSound() {
		return "Munch, Munch, Yum!";
	}

	

}
