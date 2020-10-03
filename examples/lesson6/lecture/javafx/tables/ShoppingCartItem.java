package lesson6.lecture.javafx.tables;

public class ShoppingCartItem {
	private String itemName;
	private String quantity;
	private String price;
	//private String totalPrice;
	public ShoppingCartItem() {
		//do nothing
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	// Computed value. Makes it possible to add this
	// as a column in a TableView
	public String getTotalPrice() {
		return (Double.valueOf(Integer.parseInt(quantity) 
				      * Double.parseDouble(price))).toString();
	}
	public String toString() {
		return itemName + ", " + quantity + ", " + price;
	}
//	public void setTotalPrice(String totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	
}
