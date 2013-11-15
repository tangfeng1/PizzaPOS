/**
 * Dispatch control the dispatching of drivers on deliveries. It tracks which
 * orders are attached to them, when they left, when they are expected to get
 * there, and when they are expected to return. It also plots their destinations
 * on a map.
 * 
 * Dispatch holds an ArrayList of DeliveryRuns, which contain a DriverUser attached to a DeliveryOrder
 */

package pos;

import java.util.ArrayList;

public class Dispatch {

	private ArrayList<DeliveryRun> dispatchedDels;
	private ArrayList<DriverUser> availableDrivers;

	/**
	 * Public constructor. Dispatch starts with:
	 * 
	 * @param dispatchedDels
	 *            a list of delivery runs
	 */
	public Dispatch(ArrayList<DeliveryRun> dispatchedDels) {
		this.dispatchedDels = dispatchedDels;
		availableDrivers = null;
	}

	public Dispatch() {
	}

	/**
	 * dispatchDriver creates a DeliveryRun from a @param driver and his @param
	 * orders. Then, it puts that DeliveryRun in the dispatchedDel ArrayList
	 * 
	 * @post The driver has been dispatched with those orders
	 * @post The driver has been removed from availableDrivers
	 */
	public void dispatchDriver(DriverUser driver,
			ArrayList<DeliveryOrder> orders) {

		dispatchedDels.add(new DeliveryRun(driver, orders));
		availableDrivers.remove(driver);
	}

	/**
	 * undispatchDriver removes a DeliveryRun @param run from dispatchDel and
	 * detaches its driver from its orders
	 * 
	 * @post The driver in run has been undispatched, and the orders have been
	 *       marked as delivered
	 */
	public void undispatchDriver(DeliveryRun run) {
		// for each dispatched delivery
		for (DeliveryRun r : dispatchedDels) {
			// if r's driver equals the driver we are searching for
			if (r.getDriver().equals(run.getDriver())) {
				// remove that run from the list of runs
				dispatchedDels.remove(r);

				// add the driver back into the list of available drivers
				availableDrivers.add(r.getDriver());

				// mark the runs taken by that driver as complete
				for (DeliveryOrder d : r.getOrders()) {
					d.setOpen(false);
				}
			}
		}
	}

	/**
	 * plotDelivery plots the location of a delivery @param order on the map.
	 * 
	 * @post The location has been plotted to the map
	 */
	public void plotDelivery(DeliveryOrder order) {
	}

	/**
	 * plotRun plots the locations of all DeliveryOrder objects in @param run on
	 * the map
	 * 
	 * @post All locations in @param run have been plotted to the map
	 */
	public void plotRun(DeliveryRun run) {
	}
}
