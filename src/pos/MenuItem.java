/**
 * A MenuItem is an item on the restaurant's menu. It is anything that the
 * customer can order, and it has a name, base price, and list of available
 * toppings and options
 * 
 * 
 * Invaritants: The MenuItem must always have a name
 * 
 * @invariant name != null The quantity must be positive
 * @invariant quantity >= 0 The base price of the item must be positive
 * @invariant basePrice >= 0 The item must have a size
 * @invariant size != null
 * 
 */

package pos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MenuItem {

	private String				name;
	private int					quantity;
	private BigDecimal			basePrice;
	private ItemSize			size;
	private ArrayList<ItemSize>	posSizes;
	private ArrayList<Topping>	posTopps;
	private ArrayList<Topping>	toppings;

	/**
	 * Public constructor. A MenuItem starts with a:
	 * 
	 * @param name
	 *            The name of the item
	 * @param quantity
	 *            The quantity of the item
	 * @param sizes
	 *            The possible sizes of the item
	 * @param toppings
	 *            The toppings of the item (may be null)
	 * 
	 * 
	 */
	public MenuItem(String name) {
		toppings = new ArrayList<Topping>();
		setPosTopps(new ArrayList<Topping>());
		posSizes = new ArrayList<ItemSize>();
	}

	/**
	 * @return the size
	 */
	public ItemSize getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(ItemSize size) {
		this.size = size;
	}

	/**
	 * @return the posSizes
	 */
	public ArrayList<ItemSize> getPosSizes() {
		return posSizes;
	}

	/**
	 * @param posSizes
	 *            the posSizes to set
	 */
	public void setPosSizes(ArrayList<ItemSize> posSizes) {
		this.posSizes = posSizes;
	}

	/**
	 * getPrice() determines the total cost of the menu item, taking into account the quantity, base
	 * price, and toppings
	 * 
	 * @return the price of this MenuItem
	 */
	public BigDecimal getPrice() {
		return basePrice.add(size.getPriceOffset()).add(priceOfToppings())
				.multiply(new BigDecimal(quantity));
	}

	private BigDecimal priceOfToppings() {
		BigDecimal priceOfTop = new BigDecimal(0);

		for (Topping p : toppings) {
			priceOfTop.add(p.getPrice());
		}

		return priceOfTop;
	}

	/**
	 * @return the quantity of the MenuItem
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 *            Change the quantity of the MenuItem
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the base price of the MenuItem
	 */
	public BigDecimal getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice
	 *            Change the base price
	 */
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return the toppings of the MenuItem
	 */
	public ArrayList<Topping> getToppings() {
		return toppings;
	}

	/**
	 * @param toppings
	 *            Change the toppings of the MenuItem
	 */
	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings = toppings;
	}

	/**
	 * @param item
	 *            Write the contents of a menu item to the database
	 */
	public void toDB(MenuItem item) {
	}

	/**
	 * 
	 * @return a MenuItem object that has been loaded from the database
	 */
	public MenuItem fromDB() {
		return null;
	}

	public void incQuantity() {
		quantity++;

	}

	public String toString() {
		return quantity + " " + name + " $" + getPrice();
	}

	public void addTopping(Topping topping) {
		if (toppings.indexOf(topping) == -1)
			toppings.add(topping);
		else
			toppings.get(toppings.indexOf(topping)).setQuantity(getQuantity() + 1);
	}

	/**
	 * @return the posTopps
	 */
	public ArrayList<Topping> getPosTopps() {
		return posTopps;
	}

	/**
	 * @param posTopps
	 *            the posTopps to set
	 */
	public void setPosTopps(ArrayList<Topping> posTopps) {
		this.posTopps = posTopps;
	}
}
