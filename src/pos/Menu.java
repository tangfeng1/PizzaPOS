
package pos;

import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuItem>	menu;

	public Menu() {
		setMenu(new ArrayList<MenuItem>());
	}

	public Menu(ArrayList<MenuItem> items) {

	}

	/**
	 * @return the menu
	 */
	public ArrayList<MenuItem> getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(ArrayList<MenuItem> menu) {
		this.menu = menu;
	}

	/**
	 * 
	 * @param item
	 *            the menu item to add to the menu
	 */
	public void addMenuItem(MenuItem item) {
		menu.add(item);
	}

}
