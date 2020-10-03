package lesson7.lecture.iterator;

import java.util.*;
import java.util.function.Consumer;

public class MyStringListWithIterator implements Iterable<String> {
	private final int INITIAL_LENGTH = 4;
	private String[] strArray;
	private int size;

	public MyStringListWithIterator() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}

	public void add(String s) {
		if (size == strArray.length)
			resize();
		strArray[size++] = s;
	}

	public String get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		return strArray[i];
	}

	public boolean find(String s) {
		for (String test : strArray) {
			if (test.equals(s))
				return true;
		}
		return false;
	}

	public void insert(String s, int pos) {
		if (pos > size)
			return;
		if (pos >= strArray.length || size + 1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length + 1];
		System.arraycopy(strArray, 0, temp, 0, pos);
		temp[pos] = s;

		System.arraycopy(strArray, pos, temp, pos + 1, strArray.length - pos);
		strArray = temp;
		++size;

	}

	public boolean remove(String s) {
		if (size == 0)
			return false;
		int index = -1;
		for (int i = 0; i < size; ++i) {
			if (strArray[i].equals(s)) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return false;
		String[] temp = new String[strArray.length];
		System.arraycopy(strArray, 0, temp, 0, index);
		System.arraycopy(strArray, index + 1, temp, index, strArray.length
				- (index + 1));
		strArray = temp;
		--size;
		return true;
	}

	private void resize() {
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2 * len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray, 0, temp, 0, len);
		strArray = temp;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}

	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<String> {

		private int pos;

		public MyIterator() {
			pos = 0;
		}

		@Override
		public boolean hasNext() {

			return pos < size;
		}

		@Override
		public String next() {

			if (!hasNext())
				throw new ArrayIndexOutOfBoundsException();
			String str = strArray[pos];
			pos++;
			return str;

			// return strArray[pos++];
		}

		// do not care about remove method for now.
		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {

		MyStringListWithIterator l = new MyStringListWithIterator();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");

		System.out.println("------using for loop-------");
		for (int i = 0; i < l.size; i++) {
			System.out.print(l.get(i) + ",");
		}
		System.out.println();
		System.out.println("------using iterator-------");
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ",");
		}
		System.out.println();
		System.out.println("-------using for each------");
		for (Object object : l) {
			System.out.println(object.toString());
		}
		
		////// New forEach default method in Iterator
		
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);				
			}	
		};
		System.out.println("------using new forEach method------");
		l.forEach(consumer);
		//l.forEach(x -> System.out.println(x));

	}

	

}
