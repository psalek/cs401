package lesson11.lecture.generics.wildcardcapture;

import java.util.List;

public class Capture {
	public void copyFirstToEnd(List<?> items) {
		//items.add(items.get(0)); //compiler error
	}
	
	public void copyFirstToEnd2(List<?> items) {
		copyFirstToEndHelper(items);
	}
	
	private <T> void copyFirstToEndHelper(List<T> items) {
		T item = items.get(0);
		items.add(item);
	}
}
