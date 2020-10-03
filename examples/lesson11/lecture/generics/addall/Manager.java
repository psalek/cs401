package lesson11.lecture.generics.addall;

class Manager extends Employee {
	public Manager(String name, int salary) {
		super(name, salary);
	}

	@Override
	public int getSalary() {
		// no direct access to private variables of superclass
		int baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(int b) {
		bonus = b;
	}
	
	//no equals (or hashCode) implementation here -- 
	//Manager uses Employee version

	private int bonus;
}
