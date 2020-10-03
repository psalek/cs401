package lesson7.lecture.enums3.java7;

import java.time.LocalDate;

public class Poster extends DisplayItem {
	private int width;
	private int height; 
	public Poster(String owner, LocalDate date, int width, int height) {
		super(owner, date);
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
