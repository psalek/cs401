package lesson9.lecture.optional_flatmap.usingoptionals.old;
import java.util.*;
public class Main {
	private static List<Optional<Person>> persons;
	
	//check if there is a Person on the list from Fairfield
	public static void main(String[] args) {
		loadData();
		System.out.println("Found a person in the list from Fairfield? " 
				+ personFromFairfield(persons));
	}
	
	private static boolean personFromFairfield(List<Optional<Person>> persons) {
		for(Optional<Person> p: persons) {
			if(p.flatMap(x -> x.getAddress())
				.flatMap(x -> x.getCity())
				.orElse("").equals("Fairfield")) {
					return true;
			}
		}
		return false;
	}
	private static void loadData() {
		persons = new ArrayList<>();
		Address address = new Address();
		address.setStreet("111 Main St");
		address.setCity("Fairfield");
		address.setState("IA");
		address.setZip("52556");
		Person p = new Person();
		p.setName("Joe");
		p.setAddress(address);
		persons.add(Optional.of(p));
		
		address = new Address();
		address.setStreet("1402 Channing Ave");
		address.setCity("Palo Alto");
		address.setState("CA");
		address.setZip("94301");
		p = new Person();
		p.setName("Tom");
		p.setAddress(address);
		persons.add(Optional.of(p));
	}
}
