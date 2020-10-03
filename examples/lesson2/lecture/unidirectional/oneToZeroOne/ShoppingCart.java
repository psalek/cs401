package lesson2.lecture.unidirectional.oneToZeroOne;

import java.util.*;

public class ShoppingCart {
	private List<Item> items;

	public void addItem(Item item) {
		items.add(item);
	}

	/** Use a factory method for construction */
	private ShoppingCart(Customer cust) {
		items = new ArrayList<Item>();
		cust.setCart(this);
	}
	public static ShoppingCart newShoppingCart(
			                       Customer cust) {
		if (cust == null)
			throw new NullPointerException(
					              "Null customer");		
		return new ShoppingCart(cust);
	}
	public List<Item> getItems() {
		return items;
	}
}
