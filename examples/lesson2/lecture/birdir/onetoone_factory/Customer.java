package lesson2.lecture.birdir.onetoone_factory;

public class Customer {
	private String name;
	private ShoppingCart cart;
	//package level access
	Customer(String name) {
		this.name = name;
		cart = new ShoppingCart(this);		
	}
	public String getName() {
		return name;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
}
