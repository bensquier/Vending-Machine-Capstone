package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	// private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT,
			SUB_MENU_OPTION_FINISH_TRANSACTION };

	private static final String ONE_DOLLAR_FEED = "Feed in 1 dollar";
	private static final String TWO_DOLLAR_FEED = "Feed in 2 dollars";
	private static final String FIVE_DOLLAR_FEED = "Feed in 5 dollars";
	private static final String TEN_DOLLAR_FEED = "Feed in 10 dollars";

	// private static final String SUB_MENU_FILLER_1 = "";
	private static final String[] FEED_MONEY_MENU_OPTIONS = { ONE_DOLLAR_FEED, TWO_DOLLAR_FEED, FIVE_DOLLAR_FEED,
			TEN_DOLLAR_FEED };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;

	}

	public void run() throws FileNotFoundException {

		Scanner userChoice = null;
		VendingMachine vm = new VendingMachine();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

					if (choice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						choice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);

						if (choice.equals(ONE_DOLLAR_FEED)) {
							vm.feedMoney(1);
						} else if (choice.equals(TWO_DOLLAR_FEED)) {
							vm.feedMoney(2);
						} else if (choice.equals(FIVE_DOLLAR_FEED)) {
							vm.feedMoney(5);
						} else if (choice.equals(TEN_DOLLAR_FEED)) {
							vm.feedMoney(10);
						}
					} else if (choice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {

						vm.displayInventory();
						userChoice = new Scanner(System.in);
						System.out.print("Choose your item: ");
						String guestChoice = userChoice.nextLine().toUpperCase();
						vm.purchaseItem(guestChoice);
					} else if (choice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						vm.change(vm.getBalance());
						vm.resetBalance();
						break;

					}
				}

			}
			if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				if (userChoice != null) {
					userChoice.close();
				}
				System.exit(0);

			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
