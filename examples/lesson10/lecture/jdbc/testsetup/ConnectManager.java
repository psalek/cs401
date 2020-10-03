package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectManager {
	
//	private static final String DB_URL 
//		= "jdbc:derby://localhost:1527/MPP_DB;create=true";
//	private static final String USERNAME = "app";
//	private static final String PASSWORD = "app";
	
	private static final String DB_URL = "jdbc:mysql:///FppDb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	/* replace with new Optional pattern
	private static Connection conn = null;
	public Connection getConnection() throws SQLException {
		if(conn == null) {	
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Got connection...");
		}
		return conn;
	}
	*/
	
	private Connection conn = null;
	private Connection myGetConn() {
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			return conn;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Connection getConnection() {
		return Optional.ofNullable(conn).orElseGet(this::myGetConn);
	}
	
	public void closeConnection(Connection con)  throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}
