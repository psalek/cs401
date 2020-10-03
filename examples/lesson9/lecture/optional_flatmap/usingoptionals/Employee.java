package lesson9.lecture.optional_flatmap.usingoptionals;

import java.util.List;

public class Employee {
	private String name;
	private int salary;
	private List<String> telephoneNumbers;
	private int winningAmount = 0;
	public Employee(String name, int salary, List<String> telNums) {
		this.name = name;
		this.salary = salary;
		telephoneNumbers = telNums;
	}
	public int getWinningAmount() {
		return winningAmount;
	}
	public void setWinningAmount(int winningAmount) {
		this.winningAmount = winningAmount;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public List<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}
	
}
