package lesson8.lecture.exercise.employeecode;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee("John", 10000);
		Employee e2 = new Employee("John", 20000);
		
		System.out.println("Are they equal according to equals? " + e1.equals(e2));
		EmployeeNameComparatorGood comparator = new EmployeeNameComparatorGood();
		System.out.println("Are they equal according to the Comparator? " 
				+ (comparator.compare(e1, e2) == 0));

	}

}
