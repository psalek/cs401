package lesson2.lecture.unidirectional.oneToZeroOneEasy;

public class Customer {
	private String name;
	private ShoppingCart cart;
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void addCart() {
		if(cart == null) cart = new ShoppingCart();
	}
	public ShoppingCart getCart() {
		return cart;
	}
}
