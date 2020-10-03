package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Be sure the JavaDb server is running and that derbyclient.jar has
 * been added as an external jar to this project.
 *
 */
public class TestConnection {
	ConnectManager cm = new ConnectManager();
	static final String readquery = "SELECT * FROM Person";
	public void testConnection() throws SQLException {
		Connection con = cm.getConnection();
		Statement stmt = con.createStatement();
		System.out.println("the read query: " + readquery);
		
		//Perform SELECT
		ResultSet rs = stmt.executeQuery(readquery);
		while(rs.next()){
			String id = rs.getString("id").trim();
			String fname = rs.getString("firstname").trim();
			System.out.println("id = " + id + " first name = " + fname);
		}
		//close Statement object; do not re-use
		stmt.close();
		cm.closeConnection(con);
	}
	
	public static void main(String[] args) {
		TestConnection tc = new TestConnection();
		try {
			tc.testConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
