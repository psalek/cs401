package lesson7.lecture.interfacestatic;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class Main {

	public static void main(String[] args) {
		Item item1 = new Item(15.00, .07, "Tissue");
		Item item2 = new Item(11.25, .07, "Nuts");
		Item item3 = new Item(13.10, .07, "Oranges");
		Item item4 = new Item(25.00, .07, "Tea");
		Item item5 = new Item(17.60, .07, "Tofu");
		
		List<Item> itemsForOrdinaryCart = new ArrayList<>();
		itemsForOrdinaryCart.add(item1);
		itemsForOrdinaryCart.add(item2);
		itemsForOrdinaryCart.add(item3);
		
		List<Item> itemsForGoldCart = new ArrayList<>();
		itemsForGoldCart.add(item4);
		itemsForGoldCart.add(item5);
		
		ShoppingCart ordinaryCart 
		   = new ShoppingCartOrdinary("Joe Ordinary", itemsForOrdinaryCart,
		      LocalDate.of(2015, 8, 2));
		ShoppingCart goldCart 
		   = new ShoppingCartGoldMember("Jim Special", itemsForGoldCart,
		      LocalDate.of(2015, 8, 2), .05);  //Gold members get a fixed discount
		System.out.println(ordinaryCart.printReceipt());
		System.out.println(goldCart.printReceipt());
	}

}
