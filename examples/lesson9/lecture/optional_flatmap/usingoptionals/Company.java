package lesson9.lecture.optional_flatmap.usingoptionals;
import java.util.*;
public class Company {
	private String name;
	private List<Employee> employees;
	private boolean hasWinningTicket;
	public Company(String name, List<Employee> list) {
		this.name = name;
		this.employees = list;
	}
	public boolean hasWinningTicket() {
		return hasWinningTicket;
	}
	public void setHasWinningTicket(boolean hasWinningTicket) {
		this.hasWinningTicket = hasWinningTicket;
	}
	public String getName() {
		return name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
}
