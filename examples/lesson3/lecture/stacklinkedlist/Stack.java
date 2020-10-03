package lesson3.lecture.stacklinkedlist;

import java.util.ArrayList;

@SuppressWarnings("serial")
class Stack<T> extends ArrayList<T> {
	private int stackPointer = 0;

	public void push(T item) {
		int insertPosition = stackPointer;
		add(insertPosition, item);
		stackPointer++;
	}

	public T pop() {
		return remove(--stackPointer);
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("1");
		stack.push("2");
		System.out.println(stack);
		
		
		//Uses base class method clear()
		stack.clear();
			
		//Pushing a new element produces a strange result
		try {			
			stack.push("1");
		} catch(Exception e) {
			System.out.println("Caught exception of type: " + e.getClass().getName());
			System.out.println("..error message: " + e.getMessage());
		}
		
		
	}

}
//Code will try to place "1" in position 2 of base array