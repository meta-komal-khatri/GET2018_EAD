package com.metacube.advertismentwebservices.dao;

import com.metacube.advertismentwebservices.entity.Category;

public interface CategoryDao extends BaseDao<Category>{
	public int insert(String title);
	public int updateName(String title,int id);
}
