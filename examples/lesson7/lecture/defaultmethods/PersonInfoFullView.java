package lesson7.lecture.defaultmethods;

public class PersonInfoFullView implements NameAddress {
	private String firstName, middleName, lastName;
	private Address address;
	PersonInfoFullView(String first, String middle, String last, 
			String st1, String st2, String c, String st, String z) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.address= Address.createFullAddress(st1, st2, c, st, z);
	}
	
	@Override
	public Address getAddress() {
		return address;
	}
	
	/** Overriding default method to give richer value for full name */
	@Override
	public String getFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	
}
