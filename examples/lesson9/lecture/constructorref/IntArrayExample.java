package lesson9.lecture.constructorref;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntArrayExample {
	public static void main(String[] args) {	
		//Set up inputs
		List<Integer> ints = Arrays.asList(3,5,2,3,8);
		
		//Create a list of int[]s by mapping ints, as input lengths, to int[] 
		//constructor
		List<int[]> intArrs = ints.stream()
				                  .map(int[]::new)
				                  .collect(Collectors.toList());
		
		//Represent each int[] in the list as a string so it can be printed,
		//mapping Arrays.toString to each int[] in the list
		List<String> intArrsStr = intArrs.stream()
				                         .map(Arrays::toString)
				                         .collect(Collectors.toList());
		System.out.println(intArrsStr);
	}
	
	public static void infStream() {
		List<int[]> intArrs = Stream.iterate(Integer.valueOf(1), n -> n+1).limit(4)
				.map(x -> x.intValue())
                .map(int[]::new)
                .collect(Collectors.toList());

		List<String> intArrsStr = intArrs.stream().map(Arrays::toString).collect(Collectors.toList());
		System.out.println(intArrsStr);	
	}
	
	
	
	
	
}
