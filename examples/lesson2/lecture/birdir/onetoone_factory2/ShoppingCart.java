package lesson2.lecture.birdir.onetoone_factory2;
import java.util.*;

public class ShoppingCart {
	private Customer owner;
	private List<Item> items = new ArrayList<>();;
	public void addItem(Item item) {
		items.add(item);
	}
	//package level
	ShoppingCart() {
	}
	public List<Item> getItems() {
		return items;
	}
	public void setCustomer(Customer cust) {
		this.owner = cust;
	}
	public Customer getOwner() {
		return owner;
	}
	
}
