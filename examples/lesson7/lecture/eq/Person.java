package lesson7.lecture.eq;

public class Person {
	private String name;
	public Person(String n) {
		this.name = n;
	}

	public boolean equals(Person p) {
		if(p == null) return false;
		Person q = (Person)p;
		return q.name.equals(name);
		
	}
}
