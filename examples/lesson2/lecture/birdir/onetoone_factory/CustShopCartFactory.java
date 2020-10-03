package lesson2.lecture.birdir.onetoone_factory;

public class CustShopCartFactory {
	public static Customer createCustomer(String name) {
		if(name == null) 
			throw new IllegalArgumentException("Customer name cannot be null");
		Customer cust = new Customer(name);
		
		//customer set in cart
		ShoppingCart cart = new ShoppingCart(cust);
		
		//cart set in customer
		cust.setCart(cart);
		
		return cust;
	}	
	
	
}
