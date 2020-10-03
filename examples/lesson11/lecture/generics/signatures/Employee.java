package lesson11.lecture.generics.signatures;

import java.time.LocalDate;


class Employee {
	//instance fields
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	// constructor
	Employee(String aName, double aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		salary = aSalary;
		hireDay = LocalDate.of(aYear, aMonth, aDay);
	}
	
	public boolean isSimilarTo(Employee e) {
		return nameSimilar(e) && salarySimilar(e);
	}
	
	
	private boolean nameSimilar(Employee e) {
		char first = e.getName().charAt(0);
		return (Math.abs(first - name.charAt(0)) < 3);
	}
	private boolean salarySimilar(Employee e) {
		return (Math.abs(e.getSalary() - salary) < 1000);
	}

	// instance methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
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
		return (e.name.equals(name) && e.salary==salary && e.hireDay.equals(hireDay));	
	}
	
	/** Override hashCode whenever you override equals */
	@Override
	public final int hashCode() {
		int result = 17;
		long salaryHashLong = Double.doubleToLongBits(salary);
		int salaryHash = (int) (salaryHashLong ^ (salaryHashLong >>> 32));
		result = 31 * result + name.hashCode();
		result = 31 * result + salaryHash;
		result = 31 * result + hireDay.hashCode();
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Employee copy = (Employee)super.clone();
		//no need to clone LocalDate
		return copy;
	}
	


	
}
