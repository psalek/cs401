package lesson6.lecture.javafx.tables;

public class Product {
	private Catalog catalog;
    private Integer productId;
    private String productName;
    private int quantityAvail;
    private double unitPrice;
    private String mfgDate;
    private String description;
    private int quantityRequested;
    
    public int getQuantityRequested() {
		return quantityRequested;
	}
	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}
	public Product(Catalog c, Integer pi, String pn, int qa, double up, String md, String d){
        productId=pi;
        productName = pn;
        quantityAvail = qa;
        unitPrice = up;
        mfgDate = md;
        catalog = c;
        description = d;
    }
    //this constructor is used when getting user-entered data in adding a new product
    public Product(Catalog c, String name, String date, int numAvail, double price){
    	this(c, null, name, numAvail, price, date, null);
    }
    /**
     * @return Returns the catalogId.
     */
    public Catalog getCatalog() {
        return catalog;
    }
    /**
     * @return Returns the mfgDate.
     */
    public String getMfgDate() {
        return mfgDate;
    }
    /**
     * @return Returns the productId.
     */
    public Integer getProductId() {
        return productId;
    }
    /**
     * @return Returns the productName.
     */
    public String getProductName() {
        return productName;
    }
    /**
     * @return Returns the quantityAvail.
     */
    public int getQuantityAvail() {
        return quantityAvail;
    }
    /**
     * @return Returns the unitPrice.
     */
    public double getUnitPrice() {
        return unitPrice;
    }
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
	public void setDescription(String description) {
		this.description = description;
	}
}
