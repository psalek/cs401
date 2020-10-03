package lesson10.lecture.libcompanion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	private String name;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Employee e = (Employee)ob;
		return e.name.equals(name) && e.salary==salary;
	}
	@Override
	public String toString() {
		return "[" + name + ", " + salary+"]";
	}
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Joe", 50000));
				add(new Employee("Jim", 75000));
				add(new Employee("Tom", 80000));
				add(new Employee("Jim", 70000));
				add(new Employee("Steve", 55000));
				add(new Employee("Jim", 100000));
				add(new Employee("Joe", 59000));
				add(new Employee("Rich", 88000));
			}
		};
		
		System.out.println(list.stream()
	               .sorted(Comparator.comparing((Employee e) -> e.getName())
	            		             .thenComparing((Employee e) -> e.getSalary(), Comparator.reverseOrder()))
	               .collect(Collectors.toList()));
		
	}
}

