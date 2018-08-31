package com.metacube.servletassignment4.facade;

import java.util.List;

import com.metacube.servletassignment4.dao.MYSQLUserDao;
import com.metacube.servletassignment4.dao.UserDao;
import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.enums.Status;

public class UserFacade {
	private static UserFacade userFacade = new UserFacade();
    
	UserDao userDao = (UserDao) MYSQLUserDao.getInstance();
  
    
    public static UserFacade getInstance(){
    	return userFacade;
    }
    public Status registerUser(User user){
    	List<User> userList=userDao.getAll();
    	for(User users:userList){
    		if(users.getEmail().equals(user.getEmail())){
    			return Status.DUPLICATED;
    		}
    	}
    	userDao.create(user);
    	return Status.CREATED;
    }

}
