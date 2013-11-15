/**
 * A DeliveryRun holds a driver and his deliveries. 
 * 
 * Invariants:
 * The driver must exist
 * 	@invariant driver != null
 * The delivery order(s) must exist, and have a quantity greater than 0
 * 	@invariant orders.size() > 0
 * 
 */

package pos;

import java.util.ArrayList;

public class DeliveryRun {
	private DriverUser driver;
	private ArrayList<DeliveryOrder> orders;

	/**
	 * Public constructor. DeliveryRun starts with:
	 * 
	 * @param driver
	 *            a DriverUser (delivery driver)
	 * @param orders
	 *            A list of DeliveryOrder objects
	 */
	public DeliveryRun(DriverUser driver, ArrayList<DeliveryOrder> orders) {
		this.driver = driver;
		this.orders = orders;
	}

	/**
	 * 
	 * @return the driver for this run
	 */
	public DriverUser getDriver() {
		return driver;
	}

	/**
	 * 
	 * @param driver
	 *            change the driver for this run
	 */
	public void setDriver(DriverUser driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @return the list of orders in this run
	 */
	public ArrayList<DeliveryOrder> getOrders() {
		return orders;
	}

	/**
	 * 
	 * @param orders
	 *            change the list of orders in this run
	 */
	public void setOrders(ArrayList<DeliveryOrder> orders) {
		this.orders = orders;
	}
}
