/**
 * The Inventory class keeps track of the inventory for the store. It contains
 * functionality for increasing and decreasing the quantities of each item in
 * its inventory, and alerts the user when items are running low or are out.
 */

package pos;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<StockItem> inventory;

	/**
	 * Public constructor.
	 */
	public Inventory() {
		inventory = new ArrayList<StockItem>();
	}

	/**
	 * @return the total number of StockItem objects in the inventory
	 */
	public int getItemsInInv() {
		return inventory.size();
	}

	/**
	 * Adds a StockItem to the inventory
	 * 
	 * @param item
	 * 
	 * @pre isInInv() == false
	 * @post isInInv() == true
	 */
	public void addToInv(StockItem item) {
		inventory.add(item);
	}

	/**
	 * 
	 * Determines if StockItem @param item is in the inventory
	 * 
	 * @return true if found, false if not
	 */
	public boolean isInInv(StockItem item) {
		if (inventory.indexOf(item) == -1) {
			return false;
		}
		return true;
	}

	/**
	 * @param inv
	 *            Write the contents of the inventory to the database
	 */
	public void toDB(Inventory inv) {
	}

	/**
	 * 
	 * @return an Inventory object that has been loaded from the database
	 */
	public Inventory fromDB() {
		return null;
	}
}
