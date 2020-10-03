package lesson9.lecture.optional_flatmap.usingoptionals.oldway;
import java.util.*;


public class Main {
	private static List<Person> persons;

	
	//check if there is a Person on the list from Fairfield
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		loadData();
		System.out.println("Found a person in the list from Fairfield? " 
				+ personFromFairfield(persons));
	}
	//check if there is a Person on the list from Fairfield

	private static boolean personFromFairfield(List<Person> persons)  {
		Person foundPerson = null;
		for(Person p: persons) {
			if(p != null) {
				Address addr = p.getAddress();
				if(addr != null) {
					String city = addr.getCity();
					if(city != null) {
						if(city.equals("Fairfield")) {
							foundPerson = p;
						}
					}
				}
			}
		}
		return foundPerson != null;
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
		persons.add(p);
		
		address = new Address();
		address.setStreet("1402 Channing Ave");
		address.setCity("Palo Alto");
		address.setState("CA");
		address.setZip("94301");
		p = new Person();
		p.setName("Tom");
		p.setAddress(address);
		persons.add(p);
	}
}
