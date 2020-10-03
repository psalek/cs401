package lesson9.lecture.optional_flatmap.usingoptionals.old;

import java.util.Optional;

public class Person {
	private String name;
	private Address address;
	public Person(){}
	public Optional<String> getName() {
		return Optional.of(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Address> getAddress() {
		return Optional.of(address);
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
