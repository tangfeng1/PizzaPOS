
package pos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

		try {
			File fMenuDB = new File("src/db/MenuDB.xml");
			File fInvDB = new File("src/db/InventoryDB.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fMenuDB);

			doc.getDocumentElement().normalize();

			System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {
				printNode(doc.getChildNodes());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printNode(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);

			if (tempNode.hasChildNodes()) {
				// loop again if has child nodes
				printNode(tempNode.getChildNodes());
			} else {
				if (tempNode.getNodeType() == Node.TEXT_NODE
						&& !tempNode.getTextContent().trim().equals("")) {
					System.out.println(tempNode.getParentNode().getNodeName() + ": "
							+ tempNode.getTextContent());
				}
				// System.out.println();
			}

		}

	}
}
