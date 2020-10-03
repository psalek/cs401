package lesson2.lecture.unidirectional.oneToZeroOneEasy;

import java.util.*;

public class ShoppingCart {
	private List<Item> items;

	public void addItem(Item item) {
		items.add(item);
	}

	/** package level constructor */
	ShoppingCart() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}
}
