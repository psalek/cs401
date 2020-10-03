package lesson10.lecture.jdbc.read_trywithres;

public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private String ssn;
	public Person(String id, String fname, String lname, String ssn) {
		this.id = id;
		this.firstName = fname;
		this.lastName =lname;
		this.ssn = ssn;
	
	}
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSsn() {
		return ssn;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + "\n id = " + id + "\n ssn = " + ssn;
	}
}
