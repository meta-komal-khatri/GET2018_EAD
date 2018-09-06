package com.metacube.training.employeeportal.dao;

import java.util.List;

public interface BaseDao<Object> {
	 public List<Object> getAll();

	    public boolean create(Object entity);
	    
	    public void update(Object t);

	    public void delete(Object t);
}
