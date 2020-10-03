package lesson2.lecture.birdir.onetoone_factory2;

public class CustShopCartFactory {
	public static Customer createCustomer(String name) {
		if(name == null) 
			throw new IllegalArgumentException("Customer name cannot be null");
		Customer cust = new Customer(name);
		ShoppingCart cart = new ShoppingCart();
		
		//use a setter into insert customer rather than using constructor
		cart.setCustomer(cust);
		
		//cart set in customer
		cust.setCart(cart);
		
		return cust;
	}
	
	
	
	
}
