package lesson11.lecture.generics.addall;

public class MyListImpl<T> implements MyList<T> {
	private Object[] arr = new Object[10];
	private int size = 0;
	public void add(T s) {
		arr[size++] = s;
	}
	public void addAll(MyList<? extends T> list) {
	//public void addAll(MyList<T> list) {
		for(int i = 0; i < list.getSize(); ++i) {
			add(list.get(i));
		}
	}
	public T get(int i) {
		if(size > i) return (T)arr[i];
		return null;
	}
	@Override
	public int getSize() {
		return size;
	}
	
}
