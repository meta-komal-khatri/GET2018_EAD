package com.metacube.advertismentwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentwebservices.Connection.ConnectionHelper;
import com.metacube.advertismentwebservices.Properties.Query;
import com.metacube.advertismentwebservices.entity.Category;

public class MYSQLCategoryDao implements CategoryDao {


	private static MYSQLCategoryDao mysqlCategoryDao = new MYSQLCategoryDao();

	public static MYSQLCategoryDao getInstance(){
		return mysqlCategoryDao;
	}


	@Override
	public List<Category> getAll() {
		List<Category> categoryList=new ArrayList<Category>();
		String query=Query.SELECT_ALL_CATEGORIES;
		ResultSet resultSet=null;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Category category=new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				categoryList.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public int create(Category entity) {
		return 0;

	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category t) {
		// TODO Auto-generated method stub

	}
	@Override
	public int insert(String name) {
		String query=Query.INSERT_NEW_CATEGORY;
		int insertedRows=0;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setString(1,name);
			insertedRows=preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertedRows;

	}


	@Override
	public int updateName(String title, int id) {
		String query=Query.UPDATE_CATEGORY_NAME;
		int updateCount=0;
		try(Connection conn=ConnectionHelper.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(query);){
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, id);
			updateCount=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;

	}

}
