package lesson3.lecture.polymorphism1;

class Manager extends Employee {
	public Manager(String name, double salary) {
		super(name, salary);
		bonus = 0;
	}
	// no direct access to private variables of superclass

	//from Manager
	public double getSalary() {	
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}

	private double bonus;
}
