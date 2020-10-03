package lesson2.lecture.bidir.onetoone.extpackage;

import lesson2.lecture.bidir.onetoone.Customer;
import lesson2.lecture.bidir.onetoone.Item;
import lesson2.lecture.bidir.onetoone.ShoppingCart;

public class Main {

	public static void main(String[] args) {
		Customer cust = new Customer("Bob");
		cust.getCart().addItem(new Item("Shirt"));
		
		//not possible to create instance of ShoppingCart outside of a Customer
		//--this is what is meant by "Customer owns the relationship"
		//new ShoppingCart(...) -- compiler error
		
		System.out.println("Bob's shopping cart: " + cust.getCart().getItems());
		
		//You can navigate from a shopping cart to its owner
		ShoppingCart cart = cust.getCart();
		System.out.println("Owner of cart: " + cart.getOwner());

	}

}
