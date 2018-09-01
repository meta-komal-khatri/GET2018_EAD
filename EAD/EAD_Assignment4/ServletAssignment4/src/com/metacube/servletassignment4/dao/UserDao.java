package com.metacube.servletassignment4.dao;

import java.sql.Date;
import java.util.List;

import com.metacube.servletassignment4.entity.BaseEntity;
import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.enums.Status;

public interface UserDao extends BaseDao<User> {

    public User getByUserCode(String code);
    public User getUserByEmailAndPassword(String email,String password);
    public User getUserByEmail(String email);
    public void updateUSer(String fistName,String lastName,Date dateOfBirth,int mobNo,String email);
    public List<User> getUserByOrganization(String organization,String email);
}