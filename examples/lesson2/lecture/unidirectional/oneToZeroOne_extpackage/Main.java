package lesson2.lecture.unidirectional.oneToZeroOne_extpackage;

import lesson2.lecture.unidirectional.oneToZeroOne.*;

public class Main {
	public static void main(String[] args) {
		Customer cust = new Customer("Bob");
		ShoppingCart cart = ShoppingCart.newShoppingCart(cust);
		cart.addItem(new Item("Shirt"));
		System.out.println(
			cust.getCart().getItems());
		
		
	}
	
}

		
