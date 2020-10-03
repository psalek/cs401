package lesson2.lecture.bidir.onetoone;

public class Item {
	String name;
	public Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
}
