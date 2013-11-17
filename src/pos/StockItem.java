/**
 * A StockItem is as anything that is held in the stores stock (e.g. cheese,
 * flour, etc.). It contains a name, price, and category.
 * 
 * Invariants:
 * The StockItem must have aname
 * 	@invariant name != null
 * 
 * The StockItem must have a non-negative price
 *	@invariant price >= 0
 *
 * The StockItem must have a category
 * 	@invariant category != null
 */

package pos;

import java.math.BigDecimal;

public class StockItem {

	private String		name, type;
	private BigDecimal	price;
	private int			quantity;

	/**
	 * Public constructor. A StockItem starts with a:
	 * 
	 * @param name
	 *            the name of the StockItem
	 */
	public StockItem(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the name of the StockItem
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            change the name of the item
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price of the item
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            change the price of the item
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
