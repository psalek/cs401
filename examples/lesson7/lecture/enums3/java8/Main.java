package lesson7.lecture.enums3.java8;

public class Main {

	public static void main(String[] args) {
		Admin admin = new Admin();
		DisplayItem[] items = admin.getAllDisplayItems();
		for(DisplayItem item : items) {
			System.out.println(item.displayInfo());
		}

	}

}
