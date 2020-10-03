package lesson11.lecture.generics.componentofarray;

import java.util.Collection;

class AbstractCollectionFirstTry {
	public static <T> T[] toArray(Collection<T> coll) {
		T[] arr = null;  //declaration permitted
		//arr = new T[coll.size()]; //compiler error
		int k = 0;
		for(T element : coll) {
			arr[k++] = element; 		  
		}
		return arr;	
	}
}
