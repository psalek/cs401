package lesson3.lecture.composition2;

import java.util.*;

public class MyStack<T> {
	private LinkedList<T> list = new LinkedList<>();
	
	public T pop() {
		if(!list.isEmpty()) {
			return list.remove();
		}
		else {
			return null;
		}
	}
	
	public void push(T a) {
		list.addFirst(a);
	}
}
