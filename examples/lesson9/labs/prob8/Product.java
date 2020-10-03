package lesson9.labs.prob8;

public class Product {
	private String productId;
	private String productName;
	private double unitPrice;
	public Product(String prodId, String prodName, double price) {
		this.productId = prodId;
		this.productName = prodName;
		this.unitPrice = price;
	}
	public String getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
}
