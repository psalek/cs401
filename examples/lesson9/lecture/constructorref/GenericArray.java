package lesson9.lecture.constructorref;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericArray {
	public static void main(String[] args) {
		List<String> strings 
		  = Arrays.asList("Eleven", "strikes", "the", "clock");
		
		//How can we convert this list to an array of strings?
		//This doesn't work:
		   //String[] stringArr = strings.toArray();
		
		//First solution
		String[] stringArr1 = strings.toArray(new String[0]);
		System.out.println(Arrays.toString(stringArr1));
		
		//Second solution, using a constructor reference
		String[] stringArr2 = strings.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(stringArr2));

		//How does the second solution work? How does the runtime use the 
		//constructor reference String[]::new (which is same as len -> new String[len])
		//to correctly determine the type of the output array?
		//The function myToArray shows how it could be done, but Java's implementation
		//is more efficient.
//		String[] stringArr3 = myToArray(strings.stream(), String[]::new);
//		System.out.println(Arrays.toString(stringArr3));
	}
	
	
	//This shows how the type String[] can be deduced from the constructor reference,
	//but Java does it more efficiently
	public static String[] myToArray(Stream<String> stream, IntFunction<String[]> f) {
		Object[] obArr = stream.toArray();
		String[] retVal =  f.apply(obArr.length);
		System.arraycopy(obArr, 0, retVal, 0, obArr.length);
		return retVal;
	}
}
