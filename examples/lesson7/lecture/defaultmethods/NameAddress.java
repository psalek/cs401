package lesson7.lecture.defaultmethods;

public interface NameAddress {
	String getFirstName();
	String getLastName();
	Address getAddress();
	
	/** Provides a default for full name */
	default String getFullName() {
		return getFirstName() + " " + getLastName();
	}
	
	/** Provides a template for formatting output */
	default String formattedOutput() {
		return getFullName() + "\n" + getAddress();
	}	
}
