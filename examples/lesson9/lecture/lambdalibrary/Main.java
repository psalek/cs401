package lesson9.lecture.lambdalibrary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		//load up some test data
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim",	"68306");
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5);
		
		//Task:get all names of customers whose city of residence begins 
		//with "Ma", in sorted order
		
		/* Step 1: create a pipeline to accomplish the task and test it 
		List<String> listStr = list.stream()
								   .filter(cust -> cust.getCity().startsWith("Ma"))
								   .map(cust -> cust.getName())							   
								   .sorted()
								   .collect(Collectors.toList());
		System.out.println(listStr); */
		
		/* Step 2: transform the pipeline into a named lambda expression 
		 * and put it into your library */
		List<String> listStr = LambdaLibrary.NAMES_IN_CITY.apply(list, "Ma");
		System.out.println(listStr);

		
	}

}
