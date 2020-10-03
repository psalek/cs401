package lesson7.lecture.hashcode.example;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Shows how to prepare the Person class to be a key
 * in a hashtable
 *
 */
public final class Person {
	private final LocalDate hireDate;
	private final String name;
	private final int age;
	public Person(String name, int age, LocalDate hire) {
		this.name = name;
		this.age = age;
		this.hireDate = hire;
	}
	@Override
	public boolean equals(Object ob) {
		if(ob==null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return hireDate.equals(p.hireDate) 
			&& name.equals(p.name)
			&& age == p.age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hireDate, name, age);
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}


