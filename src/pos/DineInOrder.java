/**
 * A DineInOrder is a type of order that requires table service from a food
 * runner. The customer places their order through the FOH, and then the food is
 * run to their table. Thus, it requires a table number so that the destination
 * for the food can be identified.
 */

package pos;

import java.util.ArrayList;
import java.util.Date;

public class DineInOrder extends Order {

	private int tableNum;

	/**
	 * Public constructor. Starts with the same parameters as Order, but adds:
	 * 
	 * @param tableNum
	 *            A table number
	 */
	public DineInOrder(int orderNum, String type, Date timePlaced,
			Date promTime, boolean open, ArrayList<MenuItem> contents,
			Customer customer, int tableNum) {
		super(orderNum);
		this.tableNum = tableNum;
	}

	/**
	 * @return the tableNum
	 */
	public int getTableNum() {
		return tableNum;
	}

	/**
	 * @param tableNum
	 *            the tableNum to set
	 */
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
}
