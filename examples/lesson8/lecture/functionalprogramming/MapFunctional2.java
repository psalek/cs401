package lesson8.lecture.functionalprogramming;

import java.util.*;
import java.util.function.Consumer;

public class MapFunctional2 {
	List<String> list = new ArrayList<String>();
	public void printAsUpperCase(List<String> strings) {
		strings.forEach(new TrimAndUpperCase(list));
		sort(list).forEach(new Print());
		
	}
	
	static class Print implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s);
		}
	}
	static List<String> sort(List<String> aList) {
		Collections.sort(aList);
		return aList;
	}
	
	static class TrimAndUpperCase implements Consumer<String> {
		TrimAndUpperCase(List<String> trimmedAndUpper) {
			this.list = trimmedAndUpper;
		}
		private List<String> list;
		
		@Override
		public void accept(String t) {
			list.add(t.trim().toUpperCase());
			
		}
		
	}
	public static void main(String[] args) {
    	MapFunctional2 mf = new MapFunctional2();
    	List<String> list = 
    			Arrays.asList("billy", "tommy  ", " rick  ", "abdul", 
    					"albert     ", "isaiah"); 
    	mf.printAsUpperCase(list);
    }
}
