package lesson7.lecture.hashcode.bad2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
	String firstName;
	String lastName;
	double salary;
	Calendar dob;
	public Person(String fname, String lname, double salary, GregorianCalendar dob) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
		this.dob = dob;
	}
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return p.firstName.equals(firstName) && p.lastName.equals(lastName) 
				&& p.salary == salary && dob.equals(p.dob);
	}
	
	public String toString() {
		return firstName + " " + lastName + ": " + salary + ", " + dob.get(Calendar.YEAR);
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
		return dob;
	}
	
}
