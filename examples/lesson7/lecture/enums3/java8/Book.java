package lesson7.lecture.enums3.java8;

import java.time.LocalDate;

public class Book implements DisplayItem {
	private String title;
	private String owner;
	private LocalDate dateToReturnToOwner;
	public Book(String owner, LocalDate date, String title) {
		this.owner = owner;
		this.dateToReturnToOwner = date;
		this.title = title;
	}
	@Override
	public String getOwner() {
		return owner;
	}
	@Override
	public LocalDate getDateToReturnToOwner() {
		return dateToReturnToOwner;
	}
	@Override
	public void setOwner(String s) {
		this.owner = s;
		
	}
	@Override
	public void setDateToReturnToOwner(LocalDate d) {
		this.dateToReturnToOwner = d;
		
	}
}
