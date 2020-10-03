package lesson8.lecture.newtech_modifylist;

import java.util.Arrays;
import java.util.List;

public class ActListConsumerMethodRef {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//ultimate goal reached: pass in list and print function only
		list.forEach(System.out::println);		
	}
}
