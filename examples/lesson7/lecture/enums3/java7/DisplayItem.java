package lesson7.lecture.enums3.java7;

import java.time.LocalDate;

public class DisplayItem {
	private String owner;
	private LocalDate dateToReturnToOwner;
	public DisplayItem(String owner, LocalDate date) {
		this.owner = owner;
		this.dateToReturnToOwner = date;
	}
		
	public String displayInfo() {
		return owner + ": " + this.getClass().getSimpleName() 
				+ ": " + dateToReturnToOwner;
	}
	
}
