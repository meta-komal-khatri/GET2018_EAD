package com.metacube.servletassignment4.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.servletassignment4.Properties.Properties;

public class ConnectionHelper {

	public static Connection getConnection() throws AssertionError{
		Connection conn=null;

		try {
			Class.forName(Properties.CLASS_PATH);
			conn=DriverManager.getConnection(Properties.DB_URL,Properties.USERNAME,Properties.PASSWORD);
		} 
		catch (ClassNotFoundException e)
		{
			throw new AssertionError("Class Not Found Exception");
		}
		catch (SQLException e)
		{
			throw new AssertionError("SqlException");
		}

		return conn;
	}


	public static void closeConection(Connection conn) throws AssertionError{
		try {
			if(conn!=null) {
				conn.close();
			}
		}

		catch(SQLException se) {
			throw new AssertionError();
		}
	}

}

