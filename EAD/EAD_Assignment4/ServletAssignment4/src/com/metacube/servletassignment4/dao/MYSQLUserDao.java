package com.metacube.servletassignment4.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.servletassignment4.Connection.ConnectionHelper;
import com.metacube.servletassignment4.Properties.Query;
import com.metacube.servletassignment4.entity.User;

public class MYSQLUserDao implements UserDao{
	
	private static MYSQLUserDao mySQLUserDao = new MYSQLUserDao();
	
    private MYSQLUserDao() {
    }

    public static MYSQLUserDao getInstance() {
     
    	return mySQLUserDao;
    
    }
	
    @Override
	public List<User> getAll() throws AssertionError {
		
    	ResultSet resultSet=null;
		
    	List<User> userList=new ArrayList<User>();
		
    	String query=Query.GET_ALL_USERS;
		
    	User user;
		
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			
			resultSet=preparedStatement.executeQuery();	
			
			if(resultSet.next()){
				
				while(resultSet.next()){
					
					Blob imageBlob=resultSet.getBlob("image");
					InputStream image = imageBlob.getBinaryStream();
					user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
							resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
							,resultSet.getString("organization"),image);
					
					userList.add(user);
				}
			}
		}
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userList;
	}

	@Override
	public void create(User newUser) {
		
		String query=Query.CREAT_NEW_USER;
		
		try(Connection conn=ConnectionHelper.getConnection();
			 PreparedStatement preparedStatement=conn.prepareStatement(query);){
			System.out.println(newUser.getOrganization());
			preparedStatement.setString(1, newUser.getFirstName());
			preparedStatement.setString(2,newUser.getLastName());
			preparedStatement.setInt(3, newUser.getAge());
			preparedStatement.setDate(4, newUser.getDateOfBirth());
			preparedStatement.setInt(5, newUser.getMobileNumber());
			preparedStatement.setString(6, newUser.getPassword());
			preparedStatement.setString(7, newUser.getEmail());
			preparedStatement.setString(8, newUser.getOrganization());
			preparedStatement.setBlob(9, newUser.getImage());
			preparedStatement.executeUpdate();
			
		}
		
		 catch (SQLException e) {
		
			 System.out.println(e.getMessage());
		} 
		
	}
	
	public User getUserByEmailAndPassword(String email,String password){
		String query=Query.LOGIN_USER;
		ResultSet resultSet=null;
		User user=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				while(resultSet.next()){
					
					Blob imageBlob=resultSet.getBlob("image");
					InputStream image = imageBlob.getBinaryStream();
					
					user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
							resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
							,resultSet.getString("organization"),image);
				}
			}
			
			
			
		} catch (SQLException | AssertionError e) {
			
			System.out.println(e.getMessage());
		}
		return user;
	}
	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByUserCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
