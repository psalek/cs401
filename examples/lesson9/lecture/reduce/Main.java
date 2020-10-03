package lesson9.lecture.reduce;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 1, 4, 3);
		Main m = new Main();
//		m.printSum(list);
//		m.printProduct(list);
		m.printDifference(list);
		List<String> strlist = Arrays.asList("A", "fellow", "down", "the", "street");
		m.printConcat(strlist);
	}
	public void printSum(List<Integer> list) {
		int sum1 = list.stream().reduce(0, (a,b) -> a + b);
		System.out.println("sum1 = " + sum1);
		int sum2 = list.parallelStream().reduce(0, (a,b) -> a + b);
		System.out.println("sum2 = " + sum2);
	}
	
	public void printProduct(List<Integer> list) {
		int prod1 = list.stream().reduce(1, (a,b) -> a * b);
		System.out.println("prod1 = " + prod1);
		int prod2 = list.parallelStream().reduce(1, (a,b) -> a * b);
		System.out.println("prod2 = " + prod2);
	}
	
	public void printDifference(List<Integer> list) {
		int diff1 = list.stream().reduce(0, (a,b) -> a - b);
		System.out.println("diff1 = " + diff1);
		int diff2 = list.parallelStream().reduce(0, (a,b) -> a - b);
		System.out.println("diff2 = " + diff2);
		
	}
	
	public void printConcat(List<String> list) {
		System.out.println(list.stream()
				               .reduce("", (x,y) -> x + " " + y));
	}

}
