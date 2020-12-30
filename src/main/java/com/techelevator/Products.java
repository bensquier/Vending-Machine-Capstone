package com.techelevator;

import java.math.BigDecimal;

public abstract class Products {

	private String brandName;
	private BigDecimal price = new BigDecimal(0.00);

	public String getBrandName() {
		return brandName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		String result = (brandName + " | " + price);
		return result;
	}

	public Products(String brandName, BigDecimal price) {
		this.price = price;
		this.brandName = brandName;
	}

	public abstract String getSound();

}
