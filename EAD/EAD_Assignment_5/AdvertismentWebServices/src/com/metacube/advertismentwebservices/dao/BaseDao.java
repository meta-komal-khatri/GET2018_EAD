package com.metacube.advertismentwebservices.dao;

import java.util.List;

public interface BaseDao<Object> {

    public List<Object> getAll();

    public int create(Object entity);
    
    public void update(Object t);

    public void delete(Object t);
}

