package lesson10.lecture.tdd.util_step2;

import java.util.*;

import lesson10.lecture.tdd.business.Address;

public class Util {
	//objective: convert a List of Address objects to a 
	//List of String arrays
	public static List<String[]> addressListToStringArrList(List<Address> listAddr){
		
		
		List<String[]> list = new ArrayList<String[]>();
		String[] arr = null;
		for(Address addr : listAddr){
			arr=new String[4];
			arr[0]=addr.getStreet();
			arr[1]=addr.getCity();
			arr[2]=addr.getState();
			arr[3]=addr.getZip();
			list.add(arr);
		}
		return list;
		
			
				
		
	}		

}









/*
public static List<String[]> addressListToStringArrList(List<Address> listAddr){
		List<String[]> list = new ArrayList<String[]>();
		String[] arr = null;
		for(Address addr : listAddr){
			arr=new String[4];
			arr[0]=addr.getStreet();
			arr[1]=addr.getCity();
			arr[2]=addr.getState();
			arr[3]=addr.getZip();
			list.add(arr);
		}
		return list;
		
	}		


*/