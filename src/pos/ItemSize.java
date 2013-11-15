/**
 * ItemSize is the size of a MenuItem. It does not have a set unit; it could be
 * in inches, or in less specific units such as medium or large. It holds a size
 * that is tied to a price; this price is used as an offset from the base price
 * of the item. ItemSize allows the restaurant to set different portion sizes for its
 * menu items without listing them separately in the menu.
 * 
 */

package pos;

import java.math.BigDecimal;

public class ItemSize {

	private String		size;
	private BigDecimal	price;

	/**
	 * Public constructor. An ItemSize starts with:
	 * 
	 * @param size
	 *            a size
	 * @param priceOffset
	 *            a price offset from the base price
	 * 
	 * 
	 *            These attributes cannot be changed.
	 */
	public ItemSize(String size, BigDecimal priceOffset) {
		this.size = size;
		this.price = priceOffset;
	}

	/**
	 * 
	 * @return the size of the item
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 
	 * @return the price of the item
	 */
	public BigDecimal getPriceOffset() {
		return price;
	}
}
