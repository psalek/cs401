package lesson3.lecture.polymorphism1;

public class Main {

	public static void main(String[] args) {
		Manager boss = new Manager("Boss Guy", 80000);
		boss.setBonus(5000);

		Employee[] staff = new Employee[3];

		staff[0] = boss;
		staff[1] = new Employee("Jimbo", 50000);
		staff[2] = new Employee("Tommy", 40000);

		// print names and salaries polymorphically
		for (Employee e : staff) {
			System.out.println("name: " + e.getName() + ", salary: "
					+ e.getSalary());
		}

	}

}
