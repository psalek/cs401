package lesson7.lecture.enums3.java7;

import java.time.LocalDate;

public class Admin {
	private DisplayItem[] items;
	public Admin() {
		populateItems();
	}
	public DisplayItem[] getAllDisplayItems() {
		return items;
	}
	
	private void populateItems() {
		items = new DisplayItem[3];
		items[0] = 
		  new Book("Willie", LocalDate.of(2018, 1, 1), "Willie's First Book");
		items[1] = 
		  new Poster("Rich", LocalDate.of(2017, 12, 1), 20, 20);
		items[2] =
		  new Software("Al", LocalDate.of(2017, 11, 1), "Insert install CD and run");	
	}
}
