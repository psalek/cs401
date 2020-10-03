package lesson9.lecture.optional_flatmap.usingoptionals;
import java.util.*;
/** 
 * In a large organization, there was a random drawing that award several Employees
 * a large bonus. At most one company has any winning Employees, but it is possible
 * that more than one Employee is a winner. Find the telephone number of the 
 * Employee with the biggest winnings.
 * @author paul_
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Company> list = loadData();
		System.out.println(telNumberOfBiggestWinnerImperative(list));
		System.out.println(telNumberOfBiggestWinner(list));

	}
	
	private static String telNumberOfBiggestWinnerImperative(List<Company> list) {
		boolean winningCompanyFound = false;
		for(Company c: list) {
			if(c.hasWinningTicket()) {
				winningCompanyFound = true;
				int largestSoFar = 0;
				Employee biggestWinner = null;
				List<Employee> emps = c.getEmployees();
				for(Employee e: emps) {
					int wins = e.getWinningAmount();
					if(wins > largestSoFar) {
						largestSoFar = wins;
						biggestWinner = e;
					}
				}
				List<String> telNums = biggestWinner.getTelephoneNumbers();
				if(telNums != null && telNums.size() > 0) 
					return telNums.get(0);
				else
					return "Winner has no phone number";			
			}		
		}
		if(!winningCompanyFound) {
			return "No winning company";
		}
		return null;
	}
	static Comparator<Employee> winnings 
	   = Comparator.comparing((Employee e) -> e.getWinningAmount());
	
	private static String telNumberOfBiggestWinner(List<Company> list) {
		return list.stream().filter((Company c) -> c.hasWinningTicket())
				            .findAny()
				            .flatMap((Company c) -> c.getEmployees().stream().max(winnings))
				            .flatMap((Employee e) -> e.getTelephoneNumbers().stream().findFirst())
				            .orElse("Not found");
	}
	
	private static List<Company> loadData() {
		List<String> telNum1 = Arrays.asList("123-456-8212", "425-456-8712");
		List<String> telNum2 = Arrays.asList("723-486-7612", "117-456-8712");
		List<String> telNum3 = Arrays.asList("183-956-1412", "746-444-9712");
		List<String> telNum4 = Arrays.asList("236-459-8290", "465-256-0012");
		List<String> telNum5 = Arrays.asList("763-453-5212", "825-456-8712");
		List<String> telNum6 = Arrays.asList("923-336-8812", "933-736-5512");
		Employee e1 = new Employee("Joe", 100000, telNum1);
		e1.setWinningAmount(50000);
		Employee e2 = new Employee("Jim", 50000, telNum2);
		e2.setWinningAmount(0);
		Employee e3 = new Employee("Ann", 70000, telNum3);
		e3.setWinningAmount(0);
		Employee e4 = new Employee("Axel", 90000, telNum4);
		e4.setWinningAmount(5000);
		Employee e5 = new Employee("Tom", 80000, telNum5);
		e5.setWinningAmount(0);
		Employee e6 = new Employee("Joan", 60000, telNum6);
		e6.setWinningAmount(0);
		Company c2 = new Company("Acme", Arrays.asList(e1, e4));
		c2.setHasWinningTicket(true);
		Company c1 = new Company("Williams Cutlery", Arrays.asList(e2, e5));
		Company c3 = new Company("Kohl's", Arrays.asList(e3, e6));
		return Arrays.asList(c1,c2,c3);
	}
}
