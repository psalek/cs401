package lesson11.lecture.generics.toarray;

import java.util.*;
import java.util.function.Consumer;

public class MyGenericListJavaWay<E> implements Iterable<E> {
	private final int INITIAL_LENGTH = 4;
	private Object[] arr;
	private int size;

	public MyGenericListJavaWay() {
		arr = new Object[INITIAL_LENGTH];
		size = 0;
	}

	public void add(E s) {
		if (size == arr.length)
			resize();
		arr[size++] = s;
	}

	public E get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		return (E)arr[i];
	}

	public boolean find(Object s) {
		for (Object test : arr) {
			if (test.equals(s))
				return true;
		}
		return false;
	}

	public void insert(E s, int pos) {
		if (pos > size)
			return;
		if (pos >= arr.length || size + 1 > arr.length) {
			resize();
		}
		Object[] temp = new Object[arr.length + 1];
		System.arraycopy(arr, 0, temp, 0, pos);
		temp[pos] = s;

		System.arraycopy(arr, pos, temp, pos + 1, arr.length - pos);
		arr = temp;
		++size;

	}

	public boolean remove(Object s) {
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
		String[] temp = new String[arr.length];
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
		Object[] temp = new Object[newlen];
		System.arraycopy(arr, 0, temp, 0, len);
		arr = temp;
	}
	
	/** 
	 *  The type T must be a supertype of the declared type E for this class 
	 *  Otherwise, an ArrayStoreException is thrown 
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] typeDeclaration) {
		//would like to do this , but cannot
		//T[] returnArray = new T[size()];
		T[] retArray = (T[])java.lang.reflect.Array
                        .newInstance(typeDeclaration.getClass().getComponentType(), size);
		for(int i = 0; i < size; ++i) {
			retArray[i] = (T)arr[i];			
		}
		return retArray;
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
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<E> {

		private int pos;

		public MyIterator() {
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (!hasNext())
				throw new ArrayIndexOutOfBoundsException();
			Object ob = arr[pos];
			pos++;
			return (E)ob;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		MyGenericListJavaWay l = new MyGenericListJavaWay();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		
		//test toArray
		System.out.println("Applying the toArray method...");
		System.out.println(Arrays.toString(l.toArray(new String[0])));
		
		

		System.out.println("------using for loop-------");
		for (int i = 0; i < l.size; i++) {
			System.out.print(l.get(i) + ",");
		}
		System.out.println();
		System.out.println("------using iterator-------");
		Iterator<Object> iterator = l.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ",");
		}
		System.out.println();
		System.out.println("-------using for each------");
		for (Object object : l) {
			System.out.println(object.toString());
		}
				
		System.out.println("------using new forEach method------");
		l.forEach(new Consumer() {
			@Override
			public void accept(Object s) {
				System.out.println(s);				
			}	
			
		});
		l.forEach(x -> System.out.println(x));
		
		System.out.println("\n====================\n");
		
	}

	

}
