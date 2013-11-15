
package pos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/**
	 * The main method controls the creation of the GUI, the initiation of the menu, dispatch
	 * system, time sheet, and loads information from all databases into memory. It also deals with
	 * access control for user logins/actions.
	 * 
	 * <pre>
	 * The program has not yet started
	 * <post> The program has finished running
	 */
	public static void main(String[] args) {
		// Create a timesheet object to keep track of punchcards
		TimeSheet timeSheet = new TimeSheet();
		// Create a dispatch object to keep track of dispatches
		Dispatch dispatch = new Dispatch();
		// Create an object to track the orders on the make table
		MakeTableOrders mto = new MakeTableOrders();
		// Create an object to track the orders on the cut table
		CutTableOrders cto = new CutTableOrders();
		// Create an object to track all orders that are currently in-house
		InHouseOrders iho = new InHouseOrders();
		// Create an object to track inventory
		Inventory inv = new Inventory();
		// Create an object to track Customers
		CustomerRecords custRecs = new CustomerRecords();
		// Create an object to track completed orders
		CompletedOrders compOrders = new CompletedOrders();

		// File file = new File("input.stuff");

		/*
		 * For this test, we create a Customer with test information then we create an Order with
		 * test information then we attach the Customer to the Order then we create a MenuItem then
		 * we add several Toppings to the MenuItem and repeat that process a few times then we test
		 * the functionality of the Order/Customer unit
		 */

		// begin test

		int input = 0;
		Scanner sc = new Scanner(System.in);

		while (input != -1) {
			System.out.println("    New Order (1)");
			System.out.println("    New Customer (2)");
			System.out.println("    Delete Order (3)");
			System.out.println("    Delete Customer (4)");
			System.out.println("    Add order to customer (5)");
			System.out.println("    Print Orders (6)");
			System.out.println("    Print Customers (7)");
			System.out.println("    Bump order from Make(8)");
			System.out.println("    Bump order from Cut (9)");
			System.out.println("    Show previous orders (10)");
			System.out.println("    Print reciept for order (11)");
			System.out.println("    Show the orders on the Make screen (12)");
			System.out.println("    Show the orders on the Cut screen (13)");
			System.out.println("    Show completed orders (14)");
			System.out.println("    Show all orders (15)");
			System.out.println("    Quit (-1)");
			System.out.println("Choose an option from the menu above:");
			input = sc.nextInt();

			if (input == 1) {
				DeliveryOrder testOrder1 = new DeliveryOrder(iho.getOrders().size() + 1);
				String loop = "";
				// startloop
				while (!loop.equals("n")) {
					// initialize pizza MenuItem
					MenuItem tmpPizza = new MenuItem("Pizza");
					ArrayList<ItemSize> posSizes = new ArrayList<ItemSize>();
					ArrayList<Topping> posTopps = new ArrayList<Topping>();

					tmpPizza.setBasePrice(new BigDecimal(10));

					posSizes.add(new ItemSize("Small", new BigDecimal(0)));
					posSizes.add(new ItemSize("Medium", new BigDecimal(2)));
					posSizes.add(new ItemSize("Large", new BigDecimal(3)));
					tmpPizza.setPosSizes(posSizes);

					posTopps.add(new Topping("Pepperoni", "Standard", new BigDecimal(2)));
					posTopps.add(new Topping("Mushroom", "Standard", new BigDecimal(2)));
					posTopps.add(new Topping("Green Peppers", "Standard", new BigDecimal(2)));
					posTopps.add(new Topping("Potatoe", "Standard", new BigDecimal(3)));
					tmpPizza.setPosTopps(posTopps);
					// done initializing

					System.out.println("What size of pizza do you want?");
					System.out.println("The possible sizes are: ");
					for (int i = 0; i < posSizes.size(); i++) {
						System.out.println("   " + i + ": " + posSizes.get(i).getSize() + "[$"
								+ posSizes.get(i).getPriceOffset() + "]");
					}
					System.out.println("Enter the index of a size: ");
					tmpPizza.setSize(posSizes.get(sc.nextInt()));

					System.out.println("What toppings do you want on your pizza?");
					System.out.println("The possible toppings are: ");
					for (int i = 0; i < posTopps.size(); i++) {
						System.out.println("   " + i + ": " + posTopps.get(i).getName() + "[$"
								+ posTopps.get(i).getPrice() + "]");
					}
					int tmpInput = 0;
					while (true) {
						System.out.println("Enter the index of a topping or -1 to quit: ");
						tmpInput = sc.nextInt();
						if (tmpInput == -1)
							break;
						tmpPizza.addTopping(posTopps.get(tmpInput));
					}

					testOrder1.addMenuItem(tmpPizza);

					System.out.println("Would you like to enter another item? (n for no)");
					loop = sc.next();
				}
				// end loop

				iho.addOrder(testOrder1);
				mto.addOrder(testOrder1);

			} else if (input == 2) {
				Customer tempCust = new Customer();
				sc.useDelimiter("\n");

				System.out.println("Enter the name of the customer: ");
				tempCust.setName(sc.next());

				System.out.println("Enter the phone number of the customer: ");
				tempCust.setPhoneNum(sc.next());

				System.out.println("Enter the first address line of the customer: ");
				tempCust.setAddr1(sc.next());

				System.out.println("Enter the second address line of the customer: ");
				tempCust.setAddr2(sc.next());

				System.out.println("Enter the city that the customer is in");
				tempCust.setCity(sc.next());

				System.out.println("Enter the zip code that the customer is in: ");
				tempCust.setZip(sc.next());

				System.out.println("Enter the state that the customer is in: ");
				tempCust.setState(sc.next());

				custRecs.addCust(tempCust);
			} else if (input == 5) {
				String pNum;
				int oNum;

				System.out
						.println("Enter the phone number of the customer you want to attach to the order: ");
				pNum = sc.next();

				System.out
						.println("Enter the order number of the order you wish to attach to the customer: ");
				oNum = sc.nextInt();

				for (Customer cust : custRecs.getCustRecs()) {
					System.out.println("Looking at phone num: " + cust.getPhoneNum());
					System.out.println("Comparing to phone num: " + pNum);
					if (cust.getPhoneNum().equals(pNum)) {
						System.out.println("Found phone number");
						for (Order o : iho.getOrders()) {
							if (o.getOrderNum() == oNum) {
								o.setCustomer(cust);
								break;
							}
						}
					}
				}
			} else if (input == 6) {
				System.out.println("Printing all in-house orders: ");

				for (Order o : iho.getOrders()) {
					System.out.println(o);
				}
			} else if (input == 7) {
				System.out.println("Printing all customers: ");

				for (Customer c : custRecs.getCustRecs()) {
					System.out.println(c);
				}
			} else if (input == 8) {
				// bump order from make to cut
				int oNum;

				System.out.println("Enter the order number of the order you would like to bump: ");
				oNum = sc.nextInt();

				for (Order o : mto.getOrders()) {
					if (o.getOrderNum() == oNum) {
						mto.bumpOrder(o, cto);
						break;
					}
				}

			} else if (input == 9) {
				// bump order from cut to completedOrders
				int oNum;

				System.out.println("Enter the order number of the order you would like to bump: ");
				oNum = sc.nextInt();

				for (Order o : cto.getOrders()) {
					if (o.getOrderNum() == oNum) {
						mto.bumpOrder(o, compOrders);
						break;
					}
				}
			} else if (input == 10) {
				// Show previous orders
			} else if (input == 11) {
				// print receipt
				System.out.println("Enter the order number of the receipt you want to print: ");

				System.out.println(iho.getOrder(sc.nextInt()));
			} else if (input == 12) {
				// show make screen

				for (Order o : mto.getOrders()) {
					System.out.println(o);
				}
			} else if (input == 13) {
				// show cut screen
				for (Order o : cto.getOrders()) {
					System.out.println(o);
				}
			} else if (input == 14) {
				// show completed orders
				for (Order o : compOrders.getOrders()) {
					System.out.println(o);
				}
			} else if (input == 15) {
				// show all orders
				for (Order o : iho.getOrders()) {
					System.out.println(o);
				}
			}

			System.out.println();
		}
		// end test

		System.exit(0);

	}
}
