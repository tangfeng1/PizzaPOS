/**
 * A Customer is a record of a client of the restaurant. It is anyone that
 * orders from the restaurant. A Customer has a name, phone number, address,
 * special instructions for delivery, and a record of available store credits.
 * Their previous orders will also be attached to them.
 * 
 * Invariants: The customer must have a name
 * 
 * @invariant name != null
 * 
 *            The customer must have a phone number
 * @invariant phoneNum != null
 * 
 *            The customer must have an address
 * @invariant addr1 != null
 */

package pos;

import java.util.ArrayList;

public class Customer {

	private String	name, phoneNum, addr1, addr2, city, zip, state, instr, credits;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	private final ArrayList<Order>	prevOrders;

	/**
	 * Public constructor. A Customer starts with a:
	 * 
	 * @param name
	 *            the name of the customer
	 * @param phoneNum
	 *            the phone number of the customer
	 * @param addr1
	 *            the first address line of the customer
	 * @param addr2
	 *            the second address line of the customer
	 * @param city
	 *            the city of the customer
	 * @param zip
	 *            the zip code of the customer
	 * @param instr
	 *            special delivery instructions for the customer
	 * @param credits
	 *            store credits for the customer
	 * @param prevOrders
	 *            the previous orders the customer has placed
	 */
	public Customer(String name, String phoneNum, String addr1, String addr2, String city,
			String zip, String instr, String credits, ArrayList<Order> prevOrders) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.zip = zip;
		this.instr = instr;
		this.credits = credits;
		this.prevOrders = prevOrders;
	}

	public Customer() {
		prevOrders = new ArrayList<Order>();
	}

	/**
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            change the name of the customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNum of the customer
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum
	 *            change the phone number of the customer
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the first address line of the customer
	 */
	public String getAddr1() {
		return addr1;
	}

	/**
	 * @param addr1
	 *            change the first address line of the customer
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
	 * @return the second address line of the customer
	 */
	public String getAddr2() {
		return addr2;
	}

	/**
	 * @param addr2
	 *            change the second address line of the customer
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	/**
	 * @return any special instructions for the delivery
	 */
	public String getInstr() {
		return instr;
	}

	/**
	 * @param instr
	 *            change the special instructions
	 */
	public void setInstr(String instr) {
		this.instr = instr;
	}

	/**
	 * @return the store credits of the customer
	 */
	public String getCredits() {
		return credits;
	}

	/**
	 * @param credits
	 *            change the store credits of the customer
	 */
	public void setCredits(String credits) {
		this.credits = credits;
	}

	/**
	 * @return the previous orders that the customer has placed
	 */
	public ArrayList<Order> getPrevOrders() {
		return prevOrders;
	}

	/**
	 * @param prevOrder
	 *            the previous order to add
	 * 
	 * @post prevOrders.size() == self@pre.prevOrders.size() + 1
	 */
	public void addPrevOrder(Order prevOrder) {
		prevOrders.add(prevOrder);
	}

	/**
	 * @param cust
	 *            Write the contents of a customer to the database
	 */
	public void toDB(Customer cust) {
	}

	/**
	 * 
	 * @return a Customer object that has been loaded from the database
	 */
	public Customer fromDB() {
		return null;
	}

	public String getDelAddr() {
		String delAddr = "";
		if (addr1 != null)
			delAddr += addr1;
		if (addr2 != null)
			delAddr += ", " + addr2;
		if (city != null)
			delAddr += ", " + city;
		if (zip != null)
			delAddr += ", " + zip;

		return delAddr;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Name: " + name + "\n  Phone: " + phoneNum + "\n  Address Line 1: " + addr1
				+ "\n  Address Line 2: " + addr2 + "\n  City: " + city + "\n  Zip Code: " + zip
				+ "\n  State: " + state + "\n  Special Instrucitons: " + instr
				+ "\n  Store Credits: " + credits + "\n  Previous Orders=" + prevOrders;
	}
}
