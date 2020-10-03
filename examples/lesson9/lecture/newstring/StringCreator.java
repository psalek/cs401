package lesson9.lecture.newstring;
import java.util.function.*;
public class StringCreator {
	public static void main(String[] args) {
	  char[] charArray = 
              {'s','p','e','a','k','i','n','g','c','s'};
	  //can create a string from a char array
	  System.out.println(new String(charArray));
	  
	  //do the same using constructor method reference
	  Function<char[], String> myFunc = String::new;
	  System.out.println(myFunc.apply(charArray));
	  
    }

}
