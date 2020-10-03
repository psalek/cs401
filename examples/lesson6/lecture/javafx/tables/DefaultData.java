package lesson6.lecture.javafx.tables;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class DefaultData {
	public static final Catalog BOOKS_CATALOG = new Catalog("Books");
	public static final Catalog CLOTHES_CATALOG = new Catalog("Clothes");
	public static final Product MESSIAH_BOOK = new Product(BOOKS_CATALOG,"Messiah Of Dune", "11/11/2000", 20, 15.00);
	public static final Product GONE_BOOK = new Product(BOOKS_CATALOG,"Gone with the Wind", "12/5/1995", 15, 12.00);
	public static final Product GARDEN_BOOK = new Product(BOOKS_CATALOG,"Garden of Rama", "1/1/2005", 5, 18.00);
	public static final Product PANTS = new Product(CLOTHES_CATALOG, "Pants", "11/1/2000", 20, 15.00);
	public static final Product SKIRTS = new Product(CLOTHES_CATALOG, "Skirts", "1/5/1995", 15, 12.00);
	public static final Product TSHIRTS = new Product(CLOTHES_CATALOG, "T-Shirts", "1/10/2005", 10, 22.00);
	public static final ObservableList<Catalog> CATALOG_LIST_DATA =
            FXCollections.observableArrayList(
            BOOKS_CATALOG, CLOTHES_CATALOG);
	public final static ObservableMap<Catalog, List<Product>> PRODUCT_LIST_DATA =
            FXCollections.observableHashMap();
	public static final List<String> DISPLAY_PRODUCT_FIELDS 
	   = Arrays.asList("Item Name", "Price", "Quantity Available", "Review");
	static {
		MESSIAH_BOOK.setDescription("You saw how good Dune was. \nThis is Part 2 of this \nunforgettable trilogy.");
		GONE_BOOK.setDescription("A moving classic that tells \na tale of love and \na tale of courage.");
		GARDEN_BOOK.setDescription("Highly acclaimed Book \nof Isaac Asimov. A real \nnail-biter.");
		PANTS.setDescription("I've seen the Grand Canyon. I've camped \nat Yellowstone. But nothing on \nearth compares to the look and feel of \nthese pants.");
		SKIRTS.setDescription("Once this brand of skirts \nbecomes well-known, watch out!");
		TSHIRTS.setDescription("Can be worn by men or women. \nAlways in style.");
		
		PRODUCT_LIST_DATA.put(BOOKS_CATALOG, 
				Arrays.asList(MESSIAH_BOOK, GONE_BOOK, GARDEN_BOOK));
						
		PRODUCT_LIST_DATA.put(CLOTHES_CATALOG, 
				Arrays.asList(PANTS, SKIRTS, TSHIRTS));
								
								
	}
}
