package com.metacube.servletassignment4.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
					//InputStream image = imageBlob.getBinaryStream();
					byte[] image=imageBlob.getBytes(1, (int) imageBlob.length());
					user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
							resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
							,resultSet.getString("organization"),image);

					userList.add(user);
					System.out.println(userList.size());
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
			preparedStatement.setString(1, newUser.getFirstName());
			preparedStatement.setString(2,newUser.getLastName());
			preparedStatement.setInt(3, newUser.getAge());
			preparedStatement.setDate(4, newUser.getDateOfBirth());
			preparedStatement.setInt(5, newUser.getMobileNumber());
			preparedStatement.setString(6, newUser.getPassword());
			preparedStatement.setString(7, newUser.getEmail());
			preparedStatement.setString(8, newUser.getOrganization());
			preparedStatement.setBinaryStream(9, new ByteArrayInputStream(newUser.getImage()),newUser.getImage().length);
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
			user=resultSetHelper(resultSet);

			/*while(resultSet.next()){

					Blob imageBlob=resultSet.getBlob("image");
					byte[] imgData=imageBlob.getBytes(1, (int) imageBlob.length()); 
					System.out.println(resultSet.getString("first_name"));
					user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
							resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
							,resultSet.getString("organization"),imgData);
				}
			 */



		} catch (SQLException | AssertionError e) {

			System.out.println(e.getMessage());
		}
		return user;
	}
	private User resultSetHelper(ResultSet resultSet){
		User user=null;
		try {
			while(resultSet.next()){

				Blob imageBlob=resultSet.getBlob("image");
				byte[] imgData=imageBlob.getBytes(1, (int) imageBlob.length()); 
				

				user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
						resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
						,resultSet.getString("organization"),imgData);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public User getUserByEmail(String email){
		String query=Query.USER_BY_EMAIL;
		ResultSet resultSet=null;
		User user=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			
			preparedStatement.setString(1, email);
			resultSet=preparedStatement.executeQuery();
			user=resultSetHelper(resultSet);
			
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

	@Override
	public void updateUSer(String fistName, String lastName, Date dateOfBirth,
			int mobNo,String email) {
		String query=Query.SET_USER;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			
			preparedStatement.setString(1, fistName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setDate(3, dateOfBirth);
			preparedStatement.setInt(4,mobNo);
			preparedStatement.setString(5,email);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getUserByOrganization(String organization,String email) {
		String query=Query.USER_BY_ORGANIZATION;
		ResultSet resultSet=null;
		User user=null;
		List<User> userList=new ArrayList<User>();
		
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			
			preparedStatement.setString(1,organization);
			preparedStatement.setString(2,email);
			resultSet=preparedStatement.executeQuery();
			
				while(resultSet.next()){

					Blob imageBlob=resultSet.getBlob("image");
					byte[] imgData=imageBlob.getBytes(1, (int) imageBlob.length()); 
					
					user=new User(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("age"),
							resultSet.getDate("date_of_birth"),resultSet.getInt("mob_no"),resultSet.getString("password"),resultSet.getString("email")
							,resultSet.getString("organization"),imgData);
					userList.add(user);
				}
			
		} catch (SQLException | AssertionError e) {

			System.out.println(e.getMessage());
		}
		return userList;
	}

}
