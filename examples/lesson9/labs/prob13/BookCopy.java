package lesson9.labs.prob13;

@SuppressWarnings("unused")
public class BookCopy {
	private Book book;
	private int copyNum;
	private boolean isAvailable;
	public BookCopy(Book book, int copyNum, boolean isAvailable) {
		this.book = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void changeAvailability() {
		isAvailable = !isAvailable;
	}
}
