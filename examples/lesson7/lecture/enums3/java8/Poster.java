package lesson7.lecture.enums3.java8;

import java.time.LocalDate;

public class Poster implements DisplayItem {
	private int width;
	private int height; 
	private String owner;
	private LocalDate dateToReturnToOwner;
	public Poster(String owner, LocalDate date, int width, int height) {
		this.owner = owner;
		this.dateToReturnToOwner = date;
		this.width = width;
		this.height = height;
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
