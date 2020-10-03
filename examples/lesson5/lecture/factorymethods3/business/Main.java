package lesson5.lecture.factorymethods3.business;

import java.util.List;

import lesson5.lecture.factorymethods3.business.dao.AddressDao;

public class Main {

	public static void main(String[] args) {
		AddressDao dao = new AddressDao();
		List<Address> list = dao.getAllAddresses();
		System.out.println("All addresses:");
		System.out.println(list);
	}

}
