package lesson7.lecture.hashcode.good;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;


public final class Person {
	final private String firstName;
	final private String lastName;
	final double salary;
	Calendar dob;
	public Person(String fname, String lname, double salary, GregorianCalendar dob) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ": " + salary + ", " + dob.get(Calendar.YEAR);
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return p.firstName.equals(firstName) && p.lastName.equals(lastName) 
				&& p.salary == salary && dob.equals(p.dob);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dob, firstName, lastName, salary);
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getSalary() {
		return salary;
	}
	public Calendar getDob() {
		return (Calendar)dob.clone();
	}
	
}
