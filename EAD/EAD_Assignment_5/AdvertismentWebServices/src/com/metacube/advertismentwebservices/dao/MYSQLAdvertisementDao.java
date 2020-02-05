package com.metacube.advertismentwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentwebservices.Connection.ConnectionHelper;
import com.metacube.advertismentwebservices.Properties.Query;
import com.metacube.advertismentwebservices.entity.Advertisement;
import com.metacube.advertismentwebservices.entity.Category;
import com.metacube.advertismentwebservices.resources.AdvertismentResource;


public class MYSQLAdvertisementDao implements AdvertisementDao{
	private static MYSQLAdvertisementDao mysqlAdvertisementDao = new MYSQLAdvertisementDao();
	
	public static MYSQLAdvertisementDao getInstance(){
		return mysqlAdvertisementDao;
	}
	
	
	@Override
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList=new ArrayList<Advertisement>();
	
		String query=Query.SELECT_ALL_ADVERTISMENT;
		ResultSet resultSet=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Advertisement advertisement=new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	@Override
	public int create(Advertisement entity) {
		String query=Query.INSERT_NEW_ADVERTISEMENT;
		int insertedRows=0;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setString(1,entity.getTitle());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setInt(3,entity.getCategory_id());
			insertedRows=preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertedRows;
		
	}

	@Override
	public void update(Advertisement t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Advertisement t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Advertisement> getAllById(int id) {
		List<Advertisement> advertisementList=new ArrayList<Advertisement>();
		
		String query=Query.SELECT_ALL_ADVERTISMENT_BY_ID;
		ResultSet resultSet=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			Advertisement advertisement=new Advertisement();
			while(resultSet.next()){
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}


	@Override
	public int updateName(String name, int id) {
		String query=Query.UPDATE_NAME;
		int updatedRows=0;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, id);
			updatedRows=preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedRows;
		
	}


	@Override
	public int deleteById(int id) {
		String query=Query.DELETE_ADVERTISEMENT_BY_ID;
		int deletedRows=0;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setInt(1, id);
			System.out.println(deletedRows);
			deletedRows=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deletedRows;
	}
	

}
