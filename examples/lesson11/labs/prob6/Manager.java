package lesson11.labs.prob6;

public class Manager extends Employee {
	private int bonus;
	public Manager(int id, String n, int s, int bonus) {
		super(id, n,s);
		this.bonus = bonus;
	}
}
