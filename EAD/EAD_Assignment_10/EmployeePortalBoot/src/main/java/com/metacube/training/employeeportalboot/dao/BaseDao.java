package com.metacube.training.employeeportalboot.dao;

import java.util.List;

public interface BaseDao<Object> {
	    public List<Object> getAll();

	    public boolean create(Object entity);
	    
	    public boolean update(Object t);

	    public boolean delete(Object t);
}
