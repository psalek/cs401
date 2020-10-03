package lesson11.lecture.generics.toarray;

import java.util.*;
import java.util.function.Consumer;

public class MyGenericListWithIterator<T> implements Iterable<T> {
	private final int INITIAL_LENGTH = 4;
	private T[] arr; 
	private Class<T> type;
	private int size;

	
	
	public MyGenericListWithIterator(Class<T> type) {   //need to specify a type
		//arr = new T[INITIAL_LENGTH];  //can't do this
		this.type = type;
		arr = createArrayInstance(INITIAL_LENGTH);
		size = 0;
	}
	//could do it this way, with warnings
	@SuppressWarnings("unchecked")
	private T[] createArrayInstance(int len) {
		return (T[])java.lang.reflect.Array.newInstance(type, len);
	}

	public void add(T s) {
		if (size == arr.length)
			resize();
		arr[size++] = s;
	}

	public T get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		return arr[i];
	}

	public boolean find(T s) {
		for (T test : arr) {
			if (test.equals(s))
				return true;
		}
		return false;
	}

	public void insert(T s, int pos) {
		if (pos > size)
			return;
		if (pos >= arr.length || size + 1 > arr.length) {
			resize();
		}
		T[] temp = createArrayInstance(arr.length + 1);
		System.arraycopy(arr, 0, temp, 0, pos);
		temp[pos] = s;

		System.arraycopy(arr, pos, temp, pos + 1, arr.length - pos);
		arr = temp;
		++size;

	}

	public boolean remove(String s) {
		if (size == 0)
			return false;
		int index = -1;
		for (int i = 0; i < size; ++i) {
			if (arr[i].equals(s)) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return false;
		T[] temp = createArrayInstance(arr.length);
		System.arraycopy(arr, 0, temp, 0, index);
		System.arraycopy(arr, index + 1, temp, index, arr.length
				- (index + 1));
		arr = temp;
		--size;
		return true;
	}

	private void resize() {
		System.out.println("resizing");
		int len = arr.length;
		int newlen = 2 * len;
		T[] temp = createArrayInstance(newlen);
		System.arraycopy(arr, 0, temp, 0, len);
		arr = temp;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(arr[i] + ", ");
		}
		sb.append(arr[size - 1] + "]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<T> {

		private int pos;

		public MyIterator() {
			pos = 0;
		}

		@Override
		public boolean hasNext() {

			return pos < size;
		}

		@Override
		public T next() {

			if (!hasNext())
				throw new ArrayIndexOutOfBoundsException();
			T str = arr[pos];
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
	
	
	public T[] toArray() {
		//note: simply returning arr here will not work -- will contain nulls
		T[] retval = createArrayInstance(size);
		System.arraycopy(arr, 0, retval, 0, size);
		return retval;
	}

	public static void main(String[] args) {	
		MyGenericListWithIterator<String> l = new MyGenericListWithIterator<String>(String.class);
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		
		//test toArray
		System.out.println("Applying the toArray method...");
		System.out.println(Arrays.toString(l.toArray()));
				

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
		l.forEach(x -> System.out.println(x));

	}

	

}
