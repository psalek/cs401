package lesson8.lecture.functionalprogramming;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapFunctional {
	public void printAsUpperCase(List<String> strings) {
		print(sort(mapUpperCase(mapTrim(strings))));
	}
	
	//Must be public in order to be easily accessible by reflection
    public String trim(String s) {
    	return s==null ? null : s.trim();
    }
	
	//Must be public in order to be easily accessible by reflection
    public String toUpper(String s) {
    	return s == null ? null : s.toUpperCase();
    }
    private void print(List<String> l) {
    	System.out.println(l);
    }
    private List<String> sort(List<String> l) {
    	Collections.sort(l);
    	return l;
    }
    //trims each string in the list
    private List<String> mapTrim(List<String> l) {
    	return map("trim", l);
    }
    
  //trims each string in the list
    private List<String> mapUpperCase(List<String> l) {
    	return map("toUpper", l);
    }
    
    public static void main(String[] args) {
    	MapFunctional mf = new MapFunctional();
    	List<String> list = 
    			Arrays.asList("billy", "tommy  ", " rick  ", "abdul", 
    					"albert     ", "isaiah"); 
    	mf.printAsUpperCase(list);
    }
	
	/**
	 * Imitation of more sophisticated map method in Java 8.
	 * The method named by methodname must have a single String
	 * argument and must return a String.
	 *    methodName is name for a function String -> String
	 */
	private List<String> map(String methodName, List<String> strings) { 
		@SuppressWarnings("rawtypes")
		Class cl = this.getClass();
		List<String> retval = new ArrayList<>();
		try {
			@SuppressWarnings("unchecked")
			Method method = cl.getDeclaredMethod(methodName, String.class);
			for(String s : strings) {
				retval.add((String)method.invoke(this, s));				
			}
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return retval;
	}
}
