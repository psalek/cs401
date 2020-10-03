package lesson10.lecture.jdbc.read_trywithres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectManager {
	
	private static final String DB_URL = "jdbc:mysql:///FppDb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
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
	
}
