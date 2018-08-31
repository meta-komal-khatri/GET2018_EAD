package com.metacube.servletassignment4.Properties;

public class Query {
	public static final String GET_ALL_USERS="SELECT * FROM user";
	public static final String CREAT_NEW_USER="INSERT INTO user (first_name,lst_name,age,date_of_birth,mob_no,password,email,\n"
			+ "organization,image) values (?,?,?,?,?,?,?,?,?)";
}
