package lesson7.lecture.interfacestatic;

import java.time.LocalDate;
import java.util.List;

public class ShoppingCartGoldMember implements ShoppingCart {
	private String name;
	private List<Item> items;
	private LocalDate dateOfPurchase;
	private double discount;
	public ShoppingCartGoldMember(String n, List<Item> items, 
		LocalDate d, double discount) {
		name = n;
		this.items = items;
		dateOfPurchase = d;
		this.discount = discount;
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
	@Override
	public double getDiscount() {
		return discount;
	}
}
