package lesson10.lecture.jdbc.read_trywithres;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		ReadPerson rc = new ReadPerson();
		try {
			Person p = rc.getPerson("John");
			System.out.println(p);
		} catch(SQLException e) {
			for(Throwable t : e) {
				System.out.println("* " + t.getMessage());
			}
		}

	}

}
