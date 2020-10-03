package lesson8.lecture.lambdaexamples.comparator4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	private SortMethod sortMethod = SortMethod.BYNAME;
	public void sort(List<Employee> emps,  SortMethod method) {	
		Collections.sort(emps, (e1,e2) ->
		{
			if(method == sortMethod) {
				return e1.name.compareTo(e2.name);
			} else {
				throw new IllegalArgumentException("Cannot compare");
			}
		});			
	}

	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
		System.out.println(emps);
	}
}
