package com.capgemini.service.Interface;

import java.util.List;

import com.capgemini.entities.Users;

public interface IUserService 
{

	Users addUser(Users u);
	Users viewUser(int userId);
	List<Users> viewAllUser();
	Users updateUser(Users u);
	void deleteUser(int userId);
	Users validateUser(int uid,String pass);
}
