package lesson8.lecture.newtech_modifylist;

import java.util.Arrays;
import java.util.List;

public class ActListJava7 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		ActListJava7 act = new ActListJava7();
		act.printEach1(list);
		System.out.println("===============");
		act.printEach2(list);
	}
	
	public void printEach1(List<String> messages) {
		for(int i = 0; i < messages.size(); ++i) {
			System.out.println(messages.get(i));
		}
	}
	//uses the implementation of the Iterator interface in a List
	public void printEach2(List<String> messages) {
		for(String msg : messages) {
			System.out.println(msg);
		}
	}
}
