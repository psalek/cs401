package lesson9.lecture.optional_flatmap.usingoptionals.old;

import java.util.Optional;

public class Address {
	private String street, city, state, zip;
	public Address(){}
	public Optional<String> getStreet() {
		return Optional.of(street);
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Optional<String> getCity() {
		return Optional.of(city);
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Optional<String> getState() {
		return Optional.of(state);
	}
	public void setState(String state) {
		this.state = state;
	}
	public Optional<String> getZip() {
		return Optional.of(zip);
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
