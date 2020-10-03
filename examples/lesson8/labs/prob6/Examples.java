package lesson8.labs.prob6;
import java.util.function.Function;
public class Examples {
	
	
	//type: Class::instanceMethod
	Function<String, String> upper1 = (String x) -> x.toUpperCase();
	Function<String, String> upper2 = String::toUpperCase;
	
	
	
	public void evaluator() {
		System.out.println(upper2.apply("hello"));
		
		
	}
	
	public static void main(String[] args) {
		Examples e = new Examples();
		e.evaluator();
		
	}
	
}
