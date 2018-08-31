package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.pojo.Employee;

public class EmployeeDao {
	Employee employee;
	List<Employee> employeeList;
	public void insertIntoEmployee(Employee employee){
		String query="insert into employee (first_name,last_name,email,age) values(?,?,?,?)";
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement statement=conn.prepareStatement(query);){
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3,employee.getEmail());
			statement.setInt(4,employee.getAge());	
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new AssertionError();
		}
	}


	public List<Employee> selectAllEmployes(){
		employeeList=new ArrayList<Employee>();
		final String query="SELECT * FROM employee";
		ResultSet resultSet=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement statement=conn.prepareStatement(query);){
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				employee=new Employee(resultSet.getString("first_name"),resultSet.getString("last_name"),
						resultSet.getString("email"),resultSet.getInt("age"));
				employeeList.add(employee);
			}
		}
		catch(SQLException ex){
			throw new AssertionError();
		}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new AssertionError("Error while closing resultset");
			}
		}
		return employeeList;
	}

	public List<Employee> selectAllEmployeeByNameAndLastName(String firstName,String lastName){
		employeeList=new ArrayList<Employee>();
		final String query="SELECT * FROM employee WHERE first_name=? AND last_name=?";
		ResultSet resultSet=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement statement=conn.prepareStatement(query);){
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				employee=new Employee(resultSet.getString("first_name"),resultSet.getString("last_name"),
						resultSet.getString("email"),resultSet.getInt("age"));
				employeeList.add(employee);
			}
		}
		catch(SQLException ex){
			throw new AssertionError();
		}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new AssertionError();
			}
		}
		return employeeList;

	}

	public Employee selectEmployeeByEmailId(String email){
		ResultSet resultSet=null;
		String query="SELECT * FROM employee WHERE email=?";
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement statement=conn.prepareStatement(query);){
			statement.setString(1, email);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				employee=new Employee(resultSet.getString("first_name"),resultSet.getString("last_name"),
						resultSet.getString("email"),resultSet.getInt("age"));

			}
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new AssertionError();
			}
		}
		return employee;
	}
	public void updateEmployeeByEmail(Employee employee){
		String query="UPDATE employee SET first_name=?,last_name=?,age=? WHERE email=?";
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement statement=conn.prepareStatement(query);){
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setInt(3, employee.getAge());
			statement.setString(4, employee.getEmail());
			statement.executeUpdate();
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}
