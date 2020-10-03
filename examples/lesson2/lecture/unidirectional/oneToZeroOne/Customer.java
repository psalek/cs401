package lesson2.lecture.unidirectional.oneToZeroOne;

public class Customer {
	private String name;
	private ShoppingCart cart;
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public ShoppingCart getCart() {
		return cart;
	}
}
