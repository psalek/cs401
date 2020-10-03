package lesson7.lecture.interfacestatic;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCart {
	String getName();
	List<Item> getItems();
	LocalDate getDateOfPurchase();
	
	default double getDiscount() {
		return 0.0;
	}
	static double computeBaseCost(List<Item> items) {
		double accum = 0.0;
		for(Item item : items) {
			accum += (item.getPrice() + item.getTax());
		}
		return accum;
	}
	
	default String printReceipt() {
		return
			"Customer: " + getName() + "\n" +
			getItems() + "\n" +
			"Total: " + Util.formatDouble(getTotalCost()) + "\n";
	}
	default double getTotalCost() {
		return (1 - getDiscount()) * computeBaseCost(getItems());
	}
}
