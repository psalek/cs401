package lesson8.lecture.newtech_modifylist;

import java.util.Arrays;
import java.util.List;

public class ActListConsumerLambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//eliminates need to know anything about Consumer
		list.forEach(s -> System.out.println(s));		
	}
	
	
}
