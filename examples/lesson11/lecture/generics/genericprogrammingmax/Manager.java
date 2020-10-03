package lesson11.lecture.generics.genericprogrammingmax;

class Manager extends Employee {
	public Manager(String name, double salary) {
		super(name, salary);
		bonus = 0;
	}

	@Override
	public double getSalary() {
		// no direct access to private variables of superclass
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}
	
	//no equals (or hashCode) implementation here -- 
	//Manager uses Employee version

	private double bonus;
	
	public String toString() {
		return getName() + ":" + getSalary();
	}
}
