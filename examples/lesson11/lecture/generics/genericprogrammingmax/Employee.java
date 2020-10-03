package lesson11.lecture.generics.genericprogrammingmax;

class Employee extends Staff {
	//instance fields
	private double salary;
	
	// constructor
	Employee(String aName, double aSalary) {
		super(aName);
		salary = aSalary;
	}

	// instance methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	/** Make equals final to prevent unwanted overriding. Use
	 * instanceof to support Liskov Substitution for subclasses
	 */
	@Override
	public final boolean equals(Object ob) {
		if (ob == null) return false;
		if (ob instanceof Employee) return false;
		Employee e = (Employee) ob;
		return (e.name.equals(name) && e.salary==salary );	
	}
	
	/** Override hashCode whenever you override equals */
	@Override
	public final int hashCode() {
		int result = 17;
		long salaryHashLong = Double.doubleToLongBits(salary);
		int salaryHash = (int) (salaryHashLong ^ (salaryHashLong >>> 32));
		result = 31 * result + name.hashCode();
		result = 31 * result + salaryHash;
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Employee copy = (Employee)super.clone();
		//no need to clone LocalDate
		return copy;
	}
	
	@Override
	public String toString() {
		return name + ":" + salary;
	}
	


	
}
