package lesson7.lecture.defaultmethods;

public class PersonInfoQuickView implements NameAddress {
	private String firstName, lastName;
	private Address address;
	PersonInfoQuickView(String firstName, String lastName, String street, 
			String city, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = Address.createShortAddress(street, city, state);
	}
	
	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

}
