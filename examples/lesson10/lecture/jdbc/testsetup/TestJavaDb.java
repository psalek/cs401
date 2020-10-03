package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJavaDb {
	//queries
	String TEST_INSERT = "INSERT INTO CUSTOMER "+
						"(name,street,city,zip) "+       	
						"VALUES('Tommy','10 E. Washington Ave','Fairfield','52556')"; 

	String TEST_UPDATE = "UPDATE CUSTOMER "+
						 "SET city = 'Mexico' "+
						 "WHERE name = 'Tommy'";

	
	String TEST_READ = "SELECT * FROM CUSTOMER WHERE name='Tommy'";
	
	
	Connection con;
	Statement stmt;
	String dburl = "jdbc:derby://localhost:1527/MPP_DB;create=true";
	String insertStmt = "";
	String selectStmt = "";
	String city = null;
	
	public static void main(String[] args) {
		TestJavaDb demo = new TestJavaDb();
		
		demo.insertExample();
		demo.readExample();
		demo.updateExample();
		demo.readExample();
		
		demo.closeConnection();
		
	}
	public TestJavaDb() {
		//load driver just once if necessary
		//not necessary for JavaDb 
		try {
			//Default username and password are "app" -- can be modified
			con = DriverManager.getConnection(dburl, "app", "app");
			System.out.println("Got connection...");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	void loadDriver() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch(ClassNotFoundException e){
			//debug
			e.printStackTrace();
		}
	}
	void closeConnection() {
		try {
			if(con !=null)
				con.close();
			System.out.println("Connection closed");
		}
		catch(SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}
		
	}
	void insertExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("insert query "+TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
			
	}
	
	
	void readExample(){
		
		
		try {
			stmt = con.createStatement();
			System.out.println("the query: "+TEST_READ);
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				city = rs.getString("city");
				String zip = rs.getString("zip");
				System.out.println("id: "+ id + " name: "+name+ "city: "+city + " zip: " + zip);
			}
			else {
				System.out.println("No records found");
			}
			stmt.close();
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		
		
		
		
	}
	void updateExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("update query "+TEST_UPDATE);
			stmt.executeUpdate(TEST_UPDATE);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		//check result
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if(rs.next()){
				String newcity = rs.getString("city");
				System.out.println("old city: " + city + " new city: " + newcity);
			}
			else {
				System.out.println("No records found");
			}
			stmt.close();
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
					
		
	}
	
}
