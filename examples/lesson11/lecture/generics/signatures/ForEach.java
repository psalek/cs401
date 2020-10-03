package lesson11.lecture.generics.signatures;
import java.util.*;
import java.util.function.*;
// void forEach(Consumer<? super T> action)
// why ? super T
public class ForEach {
	
	public static void main(String[] args) {
		ForEach m = new ForEach();
		m.usingInnerClass();
		//m.usingLambdas();
	}
	
	public void usingInnerClass() {
		System.out.println("Using inner classes");
		List<Comparable<?>> nonNullComparables = new ArrayList<>();
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<String> strings = Arrays.asList("A", "B", "C");
		ints.forEach(new ComparableConsumer(nonNullComparables)); //T is Integer
		strings.forEach(new ComparableConsumer(nonNullComparables));  //T is String
		System.out.println(nonNullComparables);
	}
	
	public void usingLambdas() {
		System.out.println("Using lambdas");
		List<Comparable<?>> nonNullComparables = new ArrayList<>();
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<String> strings = Arrays.asList("A", "B", "C");
		//The Consumer type here must be Comparable, but T is Integer
		//or String
		ints.forEach(x -> {if(x != null) nonNullComparables.add(x);});
		strings.forEach(x -> {if(x != null) nonNullComparables.add(x);});
		System.out.println(nonNullComparables);
		
	}
	
	class ComparableConsumer implements Consumer<Comparable<?>> {
		public ComparableConsumer(List<Comparable<?>> comps) {
			this.nonNullComparables =comps;
		}
		List<Comparable<?>> nonNullComparables = new ArrayList<>();
		@Override
		public void accept(Comparable<?> t) {
			if(t != null) nonNullComparables.add(t);
			
		}		
	}
}
