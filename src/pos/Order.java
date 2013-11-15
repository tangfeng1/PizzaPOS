/**
 * An Order is the object that all orders will be stored as. It contains an
 * order/ticket number, a time placed and a time promised, an open/closed
 * status, and the contents of the order (stored as MenuItems). It also holds
 * the Customer that the order has been placed for.
 * 
 * Invariants:
 * 
 * All order numbers will be unique and greater than 0
 * 	@invariant orderNum > 0
 * type must never be null
 * 	@invariant type != null
 * The Order must always be open or closed
 * 	@invariant open != null
 * The Order must always have a time placed
 * 	@invariant timePlaced != null
 */

package pos;

import java.util.ArrayList;
import java.util.Date;

public abstract class Order {

	private final int orderNum;
	private Date timePlaced, promTime;
	private boolean open;
	private ArrayList<MenuItem> contents;
	private Customer customer;

	/**
	 * Public constructor. An Order starts with:
	 * 
	 * @param orderNum
	 *            an order number
	 * @param timePlaced
	 *            a time placed
	 * @param promTime
	 *            a promise time
	 * @param open
	 *            an open/closed status
	 * @param contents
	 *            the contents of the order
	 * 
	 */
	public Order(int orderNum) {
		this.orderNum = orderNum;
		open = true;
		timePlaced = new Date();
		// sets promise time 30 min after timePlaced
		promTime = new Date(timePlaced.getTime() + 1800000);
		contents = new ArrayList<MenuItem>();
	}

	/**
	 * @param timePlaced the timePlaced to set
	 */
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the time the order was placed
	 */
	public Date getTimePlaced() {
		return timePlaced;
	}

	/**
	 * @return the time the order was promised
	 */
	public Date getPromTime() {
		return promTime;
	}

	/**
	 * @param promTime
	 *            change the promise time
	 */
	public void setPromTime(Date promTime) {
		this.promTime = promTime;
	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open
	 *            change the status of the order
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the contents of the order
	 */
	public ArrayList<MenuItem> getContents() {
		return contents;
	}

	/**
	 * @param contents
	 *            the contents to set
	 */
	public void setContents(ArrayList<MenuItem> contents) {
		this.contents = contents;
	}

	/**
	 * @param item
	 *            Add an item to the order, or increases its quantity if it
	 *            already exists
	 * 
	 * @post findMenuItem(item) >= 0
	 */
	public void addMenuItem(MenuItem item) {
		for (MenuItem i : contents) {
			if (i.equals(item)) {
				i.setQuantity(i.getQuantity() + 1);
				return;
			}
		}
		contents.add(item);
	}

	/**
	 * @param item
	 *            Remove an item from the order
	 * 
	 * @pre findMenuItem(item) != -1
	 * @post findMenuItem(item) >= 0
	 * @post contents.size() = self@pre.contents.size() + 1
	 */
	public void removeMenuItem(MenuItem item) {
		for (MenuItem i : contents) {
			if (i.equals(item)) {
				i.setQuantity(i.getQuantity() - 1);
				return;
			}
		}

		contents.remove(item);
	}

	/**
	 * Change the quantity of an item
	 * 
	 * @param item
	 * @param quantity
	 * 
	 * @post getQuantity(item) != self@pre.getQuantity(item)
	 */
	public void changeQuantity(MenuItem item, int quantity) {
		// might not need
	}

	/**
	 * getQuantity() gets the quantity of the item in the current Order
	 * 
	 * @param item
	 * @return the quantity of the item
	 * 
	 * @pre item != null
	 */
	public int getQuantity(MenuItem item) {
		int count = 0;

		for (MenuItem i : contents) {
			if (i.equals(item)) {
				count++;
			}
		}

		return count;
	}

	/**
	 * findMenuItem() finds the item in the contents of the order and returns
	 * its location
	 * 
	 * @param item
	 * @return the location of the item, or -1 if not found
	 * 
	 * @pre contents != null
	 */
	public int findMenuItem(MenuItem item) {
		return contents.indexOf(item);
	}

	/**
	 * @param order
	 *            Write the contents of a order to the database
	 */
	public void toDB(Order order) {
	}

	/**
	 * 
	 * @return a Order object that has been loaded from the database
	 */
	public Order fromDB() {
		return null;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order #" + orderNum + ":\n" + "  Placed: " + timePlaced + "\n  Promised: " + promTime
				+ "\n  Open: " + open + "\n  Contents: " + contents + "\n  Customer: "
				+ customer;
	}
	
	
}
