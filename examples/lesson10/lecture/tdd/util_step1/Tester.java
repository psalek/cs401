package lesson10.lecture.tdd.util_step1;

import static org.junit.Assert.*;
import lesson10.lecture.tdd.business.Address;
import lesson10.lecture.tdd.util_step1.*;

import java.util.*;

import org.junit.Test;

public class Tester {
	@Test
	public void runAddressListToStringArrList() {
		Address addr1 = new Address("Street", "City", "State","Zip");
		Address addr2 = new Address("Street2", "City2", "State2","Zip2");
		List<String[]> expectedReturn = new ArrayList<String[]>();
		String[] addr1Str = {"Street", "City", "State","Zip"};
		String[] addr2Str = {"Street2", "City2", "State2","Zip2"};
		expectedReturn.add(addr1Str);
		expectedReturn.add(addr2Str);
		
		List<Address> listAddr = new ArrayList<Address>();
		listAddr.add(addr1);
		listAddr.add(addr2);
		List<String[]> listArr = Util.addressListToStringArrList(listAddr);
		assertTrue("Expected two lists: [Street, City, State,Zip], [Street2, City2, State2,Zip2]",
				sameElements(listArr,expectedReturn));
		
		
	}
	private static boolean sameElements(List<String[]> l1, List<String[]> l2) {
		if(l1==l2) return true;
		if(l1 == null && l2==null) return true;
		if(l1 == null || l2 == null) return false;
		if(l1.size() != l2.size()) return false;
		for(int i = 0; i < l1.size(); ++i) {
			boolean foundMatch = false;
			for(int j = 0; j < l2.size(); ++j){
				
				String[] arr1 = l1.get(i);
				String[] arr2 = l2.get(j);
				if(sameArray(arr1,arr2)) foundMatch=true;
			}
			if(!foundMatch) return false;
		}
		return true;
	}
	
	private static boolean sameArray(String[] arr1, String[] arr2) {
		if(arr1.length != arr2.length) return false;
		for(int i = 0; i < arr1.length; ++i) {
			if(!arr1[i].equals(arr2[i])) return false;
		}
		return true;
	}
	
}
