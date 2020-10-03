package lesson8.lecture.newtech_modifylist;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ActListConsumerInner {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		ActListConsumerInner act = new ActListConsumerInner();
		ActListConsumerInner.MyConsumer consumer = act.new MyConsumer();
		act.printEach(consumer, list);		
	}
	
	//Function for printing to console has been "passed in" via the consumer
	public void printEach(MyConsumer consumer, List<String> list) {
		//still using imperative approach here
		for(String s : list) {
			consumer.accept(s);
		}
	}
	
	class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s);
		}
	}
	
}
