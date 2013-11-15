/**
 * InHouseOrders contains all of the orders for a business day.
 */

package pos;

import java.util.ArrayList;

public class InHouseOrders {

	private ArrayList<Order>	orders;

	public InHouseOrders() {
		orders = new ArrayList<Order>();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		if (orders.indexOf(order) != -1)
			System.out.println("Order already exists.");
		else {
			orders.add(order);

		}
	}

	public void removeOrder(Order order) {
		orders.remove(order);
	}

	public Order getOrder(int orderNum) {
		for (Order o : orders) {
			if (o.getOrderNum() == orderNum) {
				return o;
			}
		}

		System.out.println("There is no order with that order number :(");
		return null;
	}

	/**
	 * bumpOrder bumps an order from one "screen" to another. For example, if an
	 * order is on the Make Screen, it can be bumped to the Cut Screen.
	 * 
	 * @param order
	 *            an instance of an Order
	 * @param screen
	 *            an InHouseOrders - can be a MakeTableOrders, a CutTableOrders,
	 *            etc.
	 */
	public void bumpOrder(Order order, InHouseOrders screen) {

		screen.addOrder(order);

		removeOrder(order);
	}
}
