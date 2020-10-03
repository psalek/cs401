package lesson3.lecture.employeemanager;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	
	List<Employee> employeeList = new ArrayList<>();
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

}
