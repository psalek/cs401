package lesson7.lecture.enums3.java7;

import java.time.LocalDate;

public class Software extends DisplayItem {
	private String installInstructions;
	private int height; 
	public Software(String owner, LocalDate date, String install) {
		super(owner, date);
		installInstructions=install;
	}
	public String getInstallInstructions() {
		return installInstructions;
	}
	public int getHeight() {
		return height;
	}
}
