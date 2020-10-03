package lesson7.lecture.interfacestatic;

public class Item {
	private double price;
	private double tax;
	private String name;
	public Item(double p, double t, String n) {
		this.price = p;
		this.tax = t;
		this.name =n;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return
		"  ItemName: " + getName() + "\n" +
		"     price: " + Util.formatDouble(getPrice()) + "\n" +
		"     tax:   " + Util.formatDouble(getPrice()*getTax()) + "\n" +
		"  ---------------\n";
		
	}
	
}
