package lesson7.lecture.hashcode.bad1;

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
