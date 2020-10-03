package lesson7.lecture.overrideequals.composition;

/** 
 * CORRECT: Person and PersonWithJob use equal-classes strategy
 * to override equals separately, but PersonWithJob does NOT
 * inherit from Person; instead, PersonWithJob aggregates Person
 *
 */
public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson.getClass() != this.getClass()) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		//As Persons, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}

}
