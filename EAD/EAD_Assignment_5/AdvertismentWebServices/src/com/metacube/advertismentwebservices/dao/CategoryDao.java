package com.metacube.advertismentwebservices.dao;

import com.metacube.advertismentwebservices.entity.Category;

public interface CategoryDao extends BaseDao<Category>{
	public void insert(String title);
	
}
