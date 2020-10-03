package lesson7.lecture.enums3.java7;

import java.time.LocalDate;

/** How can we integrate this class with the other DisplayItems for processing?
    DinosaurStatue is one of a kind -- it should be implemented as a singleton 
 */
public enum DinosaurStatue {//extends DisplayItem {// -- compiler error
	Dinosaur_Item;
	
	public static final String OWNER = "Tom Ripley";
	public static final LocalDate RETURN_DATE = LocalDate.of(2017, 11, 1);
	public static final String NAME = "Tyrannosaurus";
	
	
	
}
