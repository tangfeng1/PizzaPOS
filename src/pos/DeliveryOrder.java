/**
 * A DeliveryOrder is the Delivery type of Order. All deliveries will be stored
 * as this type of Order. It extends Order, and adds delivery-specific
 * information to the Order
 * 
 * A Customer is attached to a DeliveryOrder; this is how the address and other
 * delivery information are derived
 */

package pos;


public class DeliveryOrder extends Order {

	public DeliveryOrder(int orderNum) {
		super(orderNum);
		// TODO Auto-generated constructor stub
	}

}
