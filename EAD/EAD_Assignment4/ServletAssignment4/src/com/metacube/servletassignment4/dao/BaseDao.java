package com.metacube.servletassignment4.dao;

import java.util.List;

import com.metacube.servletassignment4.entity.BaseEntity;
import com.metacube.servletassignment4.entity.User;
public interface BaseDao<Object> {

    public List<Object> getAll();

    public void create(Object entity);
    
    public void update(Object t);

    public void delete(Object t);
}
