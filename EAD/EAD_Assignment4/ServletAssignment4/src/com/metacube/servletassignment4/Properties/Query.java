package com.metacube.servletassignment4.Properties;

public class Query {
	public static final String GET_ALL_USERS="SELECT * FROM users";
	public static final String CREAT_NEW_USER="INSERT INTO users (first_name,last_name,age,date_of_birth,mob_no,password,email,\n"
			+ "organization,image) values (?,?,?,?,?,?,?,?,?)";
	public static final String LOGIN_USER="SELECT * FROM users WHERE email=? AND password=?";
	public static final String USER_BY_EMAIL="SELECT * FROM users WHERE email=?";
	public static final String SET_USER="UPDATE users SET first_name=?,last_name=?,date_of_birth=?,mob_no=? WHERE email=?";
	public static final String USER_BY_ORGANIZATION="SELECT * FROM users WHERE organization=? AND email<>?";
}
