package com.techelevator;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

	private BigDecimal balance = new BigDecimal(0.00).setScale(2);
	private Map<String, List<Products>> inventory = new TreeMap<>();
	private Logger writer = new Logger();
	private int numQuarters = 0;

	public int getNumQuarters() {
		return numQuarters;
	}

	public int getNumDimes() {
		return numDimes;
	}

	public int getNumNickels() {
		return numNickels;
	}

	public double getNewBalance() {
		return newBalance;
	}

	private int numDimes = 0;
	private int numNickels = 0;
	private double newBalance = 0;
	private PrintStream out;

	public VendingMachine() throws FileNotFoundException {
		this(System.out);
	}

	public VendingMachine(OutputStream output) throws FileNotFoundException {
		StockReader reader = new StockReader();
		inventory = reader.importFile();
		out = new PrintStream(output);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void feedMoney(int money) {
		String typeOfTransaction = "FEED MONEY";
		if (money == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(typeOfTransaction, new BigDecimal(1.00), balance);
		}
		if (money == 2) {
			balance = balance.add(new BigDecimal(2.00));
			writer.writer(typeOfTransaction, new BigDecimal(2.00), balance);
		}
		if (money == 5) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(typeOfTransaction, new BigDecimal(5.00), balance);
		}
		if (money == 10) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(typeOfTransaction, new BigDecimal(10.00), balance);
		}
		// System.out.println("");
		out.println("Your balance is: $" + balance);
	}

	public void resetBalance() {
		this.balance = new BigDecimal(0.00);
	}

	public void displayInventory() {

		for (Map.Entry<String, List<Products>> productDescription : getInventory().entrySet()) {

			String productLocation = productDescription.getKey();
			List<Products> priceAndName = productDescription.getValue();
			if (priceAndName.size() == 1) {

				out.println(productLocation + " is SOLD OUT");

			} else {
				out.println(productLocation + " | " + priceAndName.get(0).toString() + " | " + (priceAndName.size() - 1)
						+ " Remaining");
			}
		}

	}

	public void purchaseItem(String guestChoice) {

		if (!getInventory().containsKey(guestChoice)) {
			out.println("The location you entered does not exist");
		}
		if (getInventory().containsKey(guestChoice)) {

			if (getInventory().get(guestChoice).size() == 1) {
				out.println("This item is SOLD OUT");
			}
			if (getInventory().get(guestChoice).size() > 1) {

				if (balance.compareTo(getInventory().get(guestChoice).get(0).getPrice()) >= 0) {
					balance = balance.subtract(getInventory().get(guestChoice).get(0).getPrice());
					Products product = getInventory().get(guestChoice).remove(0);
					out.println(getInventory().get(guestChoice).get(0).getSound());
					out.println("You purchased " + getInventory().get(guestChoice).get(0).getBrandName() + " for $"
							+ getInventory().get(guestChoice).get(0).getPrice() + " Your balance is $" + balance);
					Products product1 = getInventory().get(guestChoice).get(0);
					writer.writer(product1.getBrandName().toString() + " " + guestChoice,
							getInventory().get(guestChoice).get(1).getPrice(), balance);
				}

			}
		}

	}

	public void change(BigDecimal balance) {

		String typeOfTransaction = "GIVE CHANGE";

		newBalance = balance.doubleValue() * 100;
		int quarter = 25;
		numQuarters = (int) (newBalance / quarter);
		newBalance = newBalance - (numQuarters * quarter);
		int dime = 10;
		numDimes = (int) (newBalance / dime);
		newBalance = newBalance - (numDimes * dime);
		int nickel = 5;
		numNickels = (int) (newBalance / nickel);
		newBalance = newBalance - (numNickels * nickel);
		out.println("Your change is " + numQuarters + " quarter(s) and " + numDimes + " dime(s) and " + numNickels
				+ " nickel(s).");
		writer.writer(typeOfTransaction, balance, new BigDecimal(newBalance));
	}

	public Map<String, List<Products>> getInventory() {
		return inventory;
	}
}
