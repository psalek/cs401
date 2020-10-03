package lesson3.lecture.composition1;

public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object p) {
		if(p == null || !(p instanceof Person)) return false;
		Person x = (Person)p;
		if (x.name.equals(name)) return true;
		return false;
	}
	

}
