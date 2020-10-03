package lesson11.lecture.generics.signatures;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import old.lesson11.labsolns.prob7.mystream.MyStream;

//Stream<R> map(Function<? super T,? extends R> mapper)
//acting on a Stream<T>
//<R> MyStream<? super R> map1(Function<? super T, R> mapper) {
//return null;
//}

public class MapOperation {
	public static void main(String[] args) {
		MapOperation mo = new MapOperation();
		mo.example1();
		//mo.example2();
	}
	
	@SuppressWarnings("unused")
	void example1() {
		List<String> words = Arrays.asList("dog", "elephant", "peacock");
		
		//T = String (type of Stream for words.stream())
		//R = Number  (since numberStream is of type Stream<Number>)
		//Note: w.length() is a subtype of Number
		Stream<Number> numberStream = 
		    words.stream().map(w -> w.length()); 
		
	    //Why not type numberStream as Stream<Integer>? Example: might need to concatenate
		//with another Stream<Number>. Here is an example:
		Stream<Number> numberStream2 =
		    words.stream().map(w -> wordValue(w));
		
		//Now we cannot change type of numberStream to Stream<Integer>
		Stream<Number> longNumberStream = myConcat(numberStream, numberStream2);

	}
	@SuppressWarnings("unused")
	void example2() {
		List<Manager> mans = Arrays.asList(
				new Manager("John", 100000, 2000, 10, 15),
				new Manager("Steve", 120000, 1998, 2, 17));
		
		//T = Manager (mouseover stream())
		//R = Number (mouseover map)
		//Note Employee is a supertype of T, getSalary is a subtype of R
		Stream<Number> stream = mans.stream().map((Employee e) -> e.getSalary());	        
	}
	
	/// auxiliary methods not used
	
	@SuppressWarnings("unchecked")
	static <T> Stream<T> myConcat(Stream<? super T> s1, Stream<? super T> s2) {
		return (Stream<T>)Stream.concat(s1, s2);
	}
	Number wordValue(String word) {
		if(word == null || word.length() == 0) return 0;
		Number retVal = null;
		if(allTheSameLetter(word)) {
			retVal = (int)word.charAt(0);
		}
		else {
			retVal = average(word.toCharArray());
		}
		return retVal;
	}
	private boolean allTheSameLetter(String word) {
		if(word == null || word.length() == 0) return true;
		char zeroth = word.charAt(0);
		for(char c: word.toCharArray()) {
			if(c!= zeroth) return false;
		}
		return true;
	}
	private double average(char[] chars) {
		if(chars == null || chars.length == 0) return 0;
		int len = chars.length;
		double sum = 0.0;
		for(char c: chars) {
			sum += (int)c;
		}
		return sum/len;
	}
}
