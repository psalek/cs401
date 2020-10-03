package lesson8.lecture.exercise.employeecode;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparatorGood implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.name.compareTo(e2.name) != 0)
			return e1.name.compareTo(e2.name);
		return e1.salary < e2.salary ? -1 : e1.salary == e2.salary ? 0 : 1;
	}
}
