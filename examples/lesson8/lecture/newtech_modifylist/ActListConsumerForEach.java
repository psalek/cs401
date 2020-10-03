package lesson8.lecture.newtech_modifylist;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ActListConsumerForEach {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		ActListConsumerForEach act = new ActListConsumerForEach();
		MyConsumer consumer = act.new MyConsumer();
		list.forEach(consumer);		
	}
	
	class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s);
		}
	}
}
