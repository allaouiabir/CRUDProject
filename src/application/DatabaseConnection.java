package application;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.SQLException;

public class DatabaseConnection {

	private static String URL="jdbc:mysql://localhost:3306/CRUDProject";
	private static String USERNAME="root"; 
	private static String PASSWORD="";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	 
	
	}
}


