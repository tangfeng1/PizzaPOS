
package pos;

import java.io.File;
import java.math.BigDecimal;

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
		// Create a menu object
		Menu menu = new Menu();
		// Creates an object for database operations
		DBOperations dbo = new DBOperations();

		File custDB = new File("src/db/custDB.xml");

		Customer cust = new Customer();
		cust.setPhoneNum("5555555555");
		cust.setName("Bob McBobbles");
		cust.setAddr1("123 Chode Dr NE");
		cust.setAddr2("Unit 2");
		cust.setCity("Atlanta");
		cust.setState("Georgia");
		cust.setZip("30318");

		custRecs.addCust(cust);

		Customer cust2 = new Customer();

		cust2.setPhoneNum("5555555555");
		cust2.setName("John Smith lol");
		cust2.setAddr1("567 Blah Ln");
		cust2.setAddr2("Unit 1");
		cust2.setCity("Atlanta");
		cust2.setState("Georgia");
		cust2.setZip("30318");

		custRecs.addCust(cust2);

		dbo.toXML(custRecs, custDB);

		MenuItem item = new MenuItem("Pizza");
		item.setSize(new ItemSize("Small", new BigDecimal(0)));
		item.addTopping(new Topping("Pepperoni", "Standard", new BigDecimal(2)));
		item.addTopping(new Topping("Mushroom", "Standard", new BigDecimal(2)));
		item.setQuantity(1);

		// dbo.toXML(item);

		// for (Customer c : custRecs.getCustRecs()) {
		// System.out.println()
		// }

		// Customer testCust = (Customer) dbo.fromXML(custDB);
		// System.out.println(testCust);

		// custRecs.addCust((Customer) dbo.fromXML(custDB));

		// System.out.println(custRecs.getCustRecs());

	}
}
