package com.metacube.servletassignment4.dao;

import com.metacube.servletassignment4.entity.BaseEntity;
import com.metacube.servletassignment4.entity.User;

public interface UserDao extends BaseDao<User> {

    public User getByUserCode(String code);
    public User getUserByEmailAndPassword(String email,String password);

}