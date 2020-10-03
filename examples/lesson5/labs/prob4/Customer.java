package lesson5.labs.prob4;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Order> orders;
	public Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
}
