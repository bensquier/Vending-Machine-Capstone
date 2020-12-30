package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Products {
	
	public Gum(String brandName, BigDecimal price) {
		super(brandName, price);
	}
	
	
	public String getSound() {
		return "Chew, Chew, Yum!";
	}

}
