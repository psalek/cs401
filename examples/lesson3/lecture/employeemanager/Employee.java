package lesson3.lecture.employeemanager;

public class Employee {
	private String name;
	
	private Double salary;
	
	private Manager manager;

	public Employee(Manager manager) {
		super();
		this.manager = manager;
		manager.addEmployee(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
		manager.addEmployee(this);
	}
	

}
