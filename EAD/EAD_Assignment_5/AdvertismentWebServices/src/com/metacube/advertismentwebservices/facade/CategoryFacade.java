package com.metacube.advertismentwebservices.facade;


import java.util.List;

import com.metacube.advertismentwebservices.dao.CategoryDao;
import com.metacube.advertismentwebservices.dao.MYSQLCategoryDao;
import com.metacube.advertismentwebservices.entity.Category;

public class CategoryFacade {
private static CategoryFacade categoryFacade = new CategoryFacade();
    
	CategoryDao categoryDao = (CategoryDao) MYSQLCategoryDao.getInstance();
 
    public static CategoryFacade getInstance(){
    	return categoryFacade;
    }
    public void insertCategory(String name){
    	categoryDao.insert(name);
    }
    public List<Category> getAll(){
    	return categoryDao.getAll();
    }
}
