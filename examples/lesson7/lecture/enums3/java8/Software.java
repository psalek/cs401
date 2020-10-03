package lesson7.lecture.enums3.java8;

import java.time.LocalDate;

public class Software implements DisplayItem {
	private String installInstructions;
	private String owner;
	private LocalDate dateToReturnToOwner;
	public Software(String owner, LocalDate date, String install) {
		this.owner = owner;
		this.dateToReturnToOwner = date;
		installInstructions=install;
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
