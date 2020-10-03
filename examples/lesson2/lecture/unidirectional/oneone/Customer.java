package lesson2.lecture.unidirectional.oneone;

public class Customer {
	private String name;
	private ShoppingCart cart;
	public Customer(String name) {
		this.name = name;
		cart = new ShoppingCart();		
	}
	public String getName() {
		return name;
	}
	public ShoppingCart getCart() {
		return cart;
	}
}
