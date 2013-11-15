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

	private String name, category;
	private BigDecimal price;
	private int quantity;

	/**
	 * Public constructor. A StockItem starts with a:
	 * 
	 * @param name
	 *            the name of the StockItem
	 * @param price
	 *            the price of the StockItem
	 * @param category
	 *            the category of the StockItem
	 * @param quantity
	 *            the number of this item that are currently in stock
	 */
	public StockItem(String name, BigDecimal price, String category,
			int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

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
	 * @return the type of the item
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param type
	 *            change the type of the item
	 */
	public void setCategory(String category) {
		this.category = category;
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

	/**
	 * 
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            set the quantity of the item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
