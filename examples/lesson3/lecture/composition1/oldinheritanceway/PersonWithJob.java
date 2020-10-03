package lesson3.lecture.composition1.oldinheritanceway;

public class PersonWithJob extends Person {
	private double salary;
	public double getSalary() {
		return salary;
	}
	PersonWithJob(String name, double s) {
		super(name);
		salary = s;
	}
	


}
