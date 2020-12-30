package com.techelevator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine test;
	Map<String, List<Products>> testInventory = new TreeMap<>();
	Beverages beverage = new Beverages("Pepsi", new BigDecimal(2.00));
	List<Products> product = new ArrayList<>();
	private ByteArrayOutputStream output;

	@Before
	public void setup() throws FileNotFoundException {
		output = new ByteArrayOutputStream();

		test = new VendingMachine(output);
		product.add(beverage);
		product.add(beverage);
		product.add(beverage);

		testInventory.put("C1", product);
	}

	@Test
	public void feedMoneyTest() {

		test.feedMoney(10);

		assertEquals(new BigDecimal("10.00"), test.getBalance());

		test.feedMoney(1);
		assertEquals(new BigDecimal("11.00"), test.getBalance());

		test.feedMoney(2);
		assertEquals(new BigDecimal("13.00"), test.getBalance());

		test.feedMoney(5);
		assertEquals(new BigDecimal("18.00"), test.getBalance());

	}

	@Test

	public void changeTest() {

		test.change(new BigDecimal("1.40"));
		assertEquals(5, test.getNumQuarters());
		assertEquals(1, test.getNumDimes());
		assertEquals(1, test.getNumNickels());

	}

	@Test

	public void purchaseItemTest() {

		assertFalse(test.getInventory().containsKey("z3"));

		test.feedMoney(10);
		assertEquals(3, product.size());
		test.purchaseItem("C1");

	}

	@Test
	public void displayItemsTest() {
		test.displayInventory();
		String[] actualLines = output.toString().split(System.lineSeparator());
		String expectedFirstLine = "A1 | Potato Crisps | 3.05 | 5 Remaining";
		String expectedLastLine = "D4 | Triplemint | 0.75 | 5 Remaining";

		assertThat(expectedFirstLine, is(actualLines[0]));
		assertEquals(expectedLastLine, actualLines[actualLines.length - 1]);
		assertEquals(16, actualLines.length);
	}

}
