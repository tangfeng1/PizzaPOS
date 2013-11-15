/**
 * A Topping is an item of food that goes on top of a larger food item, for
 * example a pepperoni on top of a pizza. It contains a name, a type (meat,
 * vegetable, etc.), and a price
 * 
 * Invariants:
 * A Topping must have a name
 * 	@invariant name != null
 * A Topping must have a type
 * 	@invariant type != null
 * A Topping must have a non-negative price
 * 	@invariant price >= 0
 */

package pos;

import java.math.BigDecimal;

public class Topping {

	private String name, type;
	private BigDecimal price;
	private int quantity;

	/**
	 * Public constructor. A Topping starts with:
	 * 
	 * @param name
	 *            a topping name
	 * @param type
	 *            a topping type
	 * @param price
	 *            a price
	 */
	public Topping(String name, String type, BigDecimal price) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = 1;
	}

	/**
	 * @return the name of the topping
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            change the name of the topping
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type of the topping
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            change the type of the topping
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the price of the topping
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            change the price of the topping
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public String toString() {
		return quantity + " " + type + " " + name + " " + price;
	}

}
