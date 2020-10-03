package lesson11.lecture.generics.swap;

import java.util.ArrayList;
import java.util.List;

public class Swap {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {		
		Swap s = new Swap();

		List list1 = new ArrayList();
		list1.add("hello");
		list1.add("goodbye");
		s.swapFirstLast(list1);
		String newPositionZero = (String)list1.get(0);
		System.out.println(newPositionZero);
		
		List<String> list2 = new ArrayList<>();
		list2.add("hello");
		list2.add("goodbye");
		s.swapFirstLast(list2);
		String newPositionZero2 = list2.get(0);
		System.out.println(newPositionZero2);
		
	}
	@SuppressWarnings("unchecked")
	public void swapFirstLastNonGeneric(List list) {
		Object temp = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.set(list.size()-1, temp);
	}
	public <T> void swapFirstLast(List<T> list) {
		T temp = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.set(list.size()-1, temp);
	}
	
	public <T> void swapFirstLastMostGeneral(List<?> list) {
		swapFirstLast(list);
	}
	
	
}
