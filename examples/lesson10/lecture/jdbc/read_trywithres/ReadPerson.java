package lesson10.lecture.jdbc.read_trywithres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ReadPerson {
	private String query = "SELECT * FROM Person WHERE firstname = ?";
	private static final Logger LOG = Logger.getLogger(ReadPerson.class.getName());
	
	public Person getPerson(String name) throws SQLException {	
		Person returnValue = null;
		//using try-with-resources - will automatically close connection, 
		//and therefore will close statement and result set
		//If an error occurs in opening or closing a connection it is thrown
		try(Connection conn = (new ConnectManager()).getConnection()) {
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, name);
			//using this try/catch to (partially) handle exceptions
			//involving statements and executing queries -- such
			//exceptions are logged and then re-thrown
			try {
				ResultSet rs = stat.executeQuery();
				returnValue = populatePerson(rs);
			} catch(SQLException e) {
				//log exception
				StringBuilder sb = new StringBuilder();
				
				//SQLException now implements Iterable, so 
				//it is possible to iterate through chained 
				//exceptions like this
				for(Throwable t : e) {
					sb.append("+ " + t.getMessage()+ "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			}
		}
		return returnValue;
	}
	private Person populatePerson(ResultSet rs) throws SQLException {
		String id = null;
		String fname = null;
		String lname = null;
		String ssn = null;
		if(rs.next()) {
			id = rs.getString("id").trim();
			fname = rs.getString("firstname").trim();
			lname = rs.getString("lastname").trim();
			ssn = rs.getString("ssn").trim();
		}
		return new Person(id, fname, lname, ssn);
	}
	
}
