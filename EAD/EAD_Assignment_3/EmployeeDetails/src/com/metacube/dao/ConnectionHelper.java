package com.metacube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	public static Connection getConnection(){ 
		Connection conn=null;
		String DB_URL = "jdbc:mysql://localhost/employeedetails";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,"root", "1234");
		} 
		 catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
		
		return conn;
}


public static void closeConection(Connection conn){
	try {
		if(conn!=null) {
			conn.close();
		}
	}
	
	catch(SQLException se) {
		se.printStackTrace();
	}
}
}
