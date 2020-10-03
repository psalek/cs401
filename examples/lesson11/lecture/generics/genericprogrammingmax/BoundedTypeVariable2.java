package lesson11.lecture.generics.genericprogrammingmax;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class BoundedTypeVariable2 {
	public static <T extends Comparable<T>> T max(List<T> list) {
		T max = list.get(0);
		for(T i : list) {  
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		return max;
	}
	

	
	//
	public static void main(String[] args) {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2011, 1, 1));
		dates.add(LocalDate.of(2014, 2, 5));
		//LocalDate mostRecent = max(dates); //compiler error
		//error because LocalDate does not implement Comparable<LocalDate>
//		LocalDate mostRecent = max2(dates); 
//		System.out.println(mostRecent);
		
//		System.out.println(  
//				   max2(dates));
		
		//similar issues for Employee and Manager
//		List<Employee> emps = new ArrayList<>();
//		emps.add(new Employee("Bob", 50000));
//		emps.add(new Manager("Steve",60000));
//		emps.add(new Employee("Harold",70000));
//		System.out.println(  //max2 does not work
//		   max3(emps, Comparator.comparing(Employee::getSalary)
//				                            .thenComparing(Employee::getName)));
//		
//		//Comparator application for LocalDates
		System.out.println(  
				   max3(dates, (LocalDate s, LocalDate t) -> s.compareTo(t)));
//		System.out.println(
//				   max3(dates, new LocalDateComparator()));
//		System.out.println(
//			max3(emps, new StaffComparator()));
		
		
	}
	
	static class LocalDateComparator implements Comparator<ChronoLocalDate> {
//		public int compare(LocalDate d1, LocalDate d2) {
//			return d1.compareTo(d2);
//		}

		@Override
		public int compare(ChronoLocalDate d1, ChronoLocalDate d2) {
			return d1.compareTo(d2);
		}
	}
	
	static class StaffComparator implements Comparator<Staff> {

		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	//fix by expanding the range of type arguments for Comparable, like this:
	public static <T extends Comparable<? super T>> T max2(List<T> list) {
		T max = list.get(0);
		for(T i : list) {  
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		return max;
	}
	//T is ChronoLocalDate
	//fix by expanding the range of type arguments for Comparable, like this:
	public static <T extends Comparable<T>> T max2_5(List<? extends T> list) {
		T max = list.get(0);
		for(T i : list) {  
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		return max;
	}
	
	
	public static <T> T max3(List<? extends T> list, Comparator<T> cmp) {
		T theMax = list.get(0);
		for(T item : list) {
			if(cmp.compare(item, theMax) > 0) {
				theMax = item;
			}	
		}
		return theMax;
	}
	
	
	public static <T> T max4(List<? extends T> list, Comparator<? super T> cmp) {
		T theMax = list.get(0);
		for(T item : list) {
			if(cmp.compare(item, theMax) > 0) {
				theMax = item;
			}	
		}
		return theMax;
	}
	
	
}
