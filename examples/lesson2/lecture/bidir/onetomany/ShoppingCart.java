package lesson2.lecture.bidir.onetomany;
import java.util.*;
public class ShoppingCart {
	private Customer owner;
	private List<Item> items = new ArrayList<>();
	
	
	public void addItem(String itemName) {
		Item item = new Item(itemName, this);
		items.add(item);
	}
	//package level
	ShoppingCart(Customer cust) {
		owner = cust;
	}
	public List<Item> getItems() {
		return items;
	}
	public Customer getOwner() {
		return owner;
	}
	
	@Override
	public String toString() {
		return items.toString();
	}
	
}
