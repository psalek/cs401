package lesson10.lecture.exceptions.connectnew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ConnectManager {
	
	private static final String DB_URL 
		= "jdbc:derby://localhost:1527/MPP_DB;create=true";
	private static final String USERNAME = "app";
	private static final String PASSWORD = "app";
	
	private Connection conn = null; 
	private Connection createConnection() {
		try {
    		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    		return conn;
    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	} 	
	}
	public Connection getConnection()  {
		Optional<Connection> connInsideWrapper = Optional.ofNullable(conn);
		    return connInsideWrapper.orElse(createConnection());
	}
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();
			String read = "SELECT * FROM Customer";
			Statement stmt = con.createStatement();
			
			System.out.println("the query: " + read);
			ResultSet rs = stmt.executeQuery(read);
			while(rs.next()) {
				System.out.println(rs.getString("id").trim() + ": " + rs.getString("name"));
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(con != null) {
				try {
				 con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
