package lesson9.lecture.comparators2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class EmployeeInfoBetter {
	static enum SortMethod {BYNAME, BYSALARY};
	Function<Employee, String> byName = e -> e.getName();
	Function<Employee, Integer> bySalary = e -> -e.getSalary();
	
	public void sort(List<Employee> emps, final SortMethod method) {
		if(method == SortMethod.BYNAME) {
			Collections.sort(emps, Comparator.comparing(byName).thenComparing(bySalary));
		} else {
			Collections.sort(emps, Comparator.comparing(bySalary).thenComparing(byName));
		}			
	}
	
	
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		EmployeeInfoBetter ei = new EmployeeInfoBetter();
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYSALARY);
		//System.out.println(emps);
	}
}
