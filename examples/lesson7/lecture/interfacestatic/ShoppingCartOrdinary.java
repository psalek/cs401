package lesson7.lecture.interfacestatic;

import java.time.LocalDate;
import java.util.List;

public class ShoppingCartOrdinary implements ShoppingCart {
	private String name;
	private List<Item> items;
	private LocalDate dateOfPurchase;
	public ShoppingCartOrdinary(String n, List<Item> items, 
		LocalDate d) {
		name = n;
		this.items = items;
		dateOfPurchase = d;
	}
	@Override
	public String getName() { 
		return name;
	}
	@Override
	public List<Item> getItems() {
		return items;
	}
	@Override
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	
}
