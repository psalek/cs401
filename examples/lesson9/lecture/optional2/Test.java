package lesson9.lecture.optional2;
import java.util.*;
import java.util.stream.Stream;
public class Test {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("dog", "cat", "mouse");
		String max = words.stream().max(String::compareTo).get();
		System.out.println(max);
		Stream<String> stream = Stream.empty();
		//throws NoSuchElementException
		System.out.println(stream.max(String::compareTo).get());
		

	}

}
