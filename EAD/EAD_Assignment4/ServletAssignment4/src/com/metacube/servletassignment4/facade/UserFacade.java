package com.metacube.servletassignment4.facade;

import java.sql.Date;
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
    			System.out.println(users.getEmail());
    			return Status.DUPLICATED;
    		}
    	}
    	userDao.create(user);
    	return Status.CREATED;
    }
    
    
    public Status logInUser(String email,String password){
    	User user=userDao.getUserByEmailAndPassword(email, password);
  
    	if(user!=null){
    		return Status.SUCCESS;
    	}
    	else{
    		System.out.println("user");
    		return Status.FAILED;
    	}
    }
    
    public User userName(String email){
    	User user=userDao.getUserByEmail(email);
    	//String name=user.getFirstName();
    	return user;
    }
    
    public Status updateUSer(String fistName,String lastName,Date dateOfBirth,int mobileNo,String email){
    	userDao.updateUSer(fistName, lastName, dateOfBirth,mobileNo ,email);
    	return Status.UPDATED;
    }
    public List<User> getUserByOrganization(String organization,String email){
    	List<User> userList=userDao.getUserByOrganization(organization,email);
    	return userList;
    }

}
