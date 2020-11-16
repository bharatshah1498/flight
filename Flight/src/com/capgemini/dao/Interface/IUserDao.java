package com.capgemini.dao.Interface;

import java.util.List;

import com.capgemini.entities.Users;

public interface IUserDao 
{
	Users addUser(Users u);
//	viewUser(BigInteger):User :-
	Users viewUser(int userId);
	List<Users> viewAllUser();
	Users updateUser(Users u);
	void deleteUser(int userId);
	Users validate(int uid,String pass);
}
