/**
 * A PickUpOrder is a specific type of Order that has been placed for pickup.
 * It extends Order, and sets a status for whether or not the food is ready
 * to be picked up.
 * 
 * Invariants:
 * The order must always be ready or unready for pickup
 * 	@invariant readyForPickup != null
 */

package pos;


public class PickUpOrder extends Order {

	private boolean readyForPickup;

	/**
	 * Public constructor. A PickupOrder has the same parameters as Order, as
	 * well as:
	 * 
	 * @param readyForPickup
	 *            denotes whether or not the order is ready for pickup
	 */
	public PickUpOrder(int orderNum, Customer customer, boolean readyForPickup) {
		super(orderNum);
		this.readyForPickup = readyForPickup;
	}

	/**
	 * 
	 * @return whether or not the PickupOrder is ready for pickup
	 */
	public boolean getReadyForPickup() {
		return readyForPickup;
	}

	/**
	 * 
	 * @param readyForPickup
	 *            Changes whether or not the PickupOrder is ready for pickup
	 */
	public void setReadyForPickup(boolean readyForPickup) {
		this.readyForPickup = readyForPickup;
	}
}
