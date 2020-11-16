package com.capgemini.dao.Impli;

import com.capgemini.dao.Interface.IUserDao;
import com.capgemini.entities.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IUserDao {
    	
	private static Map<Integer, Users> usersData = new HashMap<>();
	
	static
	{
		Users defaultUser1 = new Users(01, "Bharat Shah", "bharat123", 7891848489L, "bharat.shah@capgemini.com", "A");
		Users defaultUser2 = new Users(02, "Pranjal Saxena", "pranjal123", 7891848489L, "bharat.shah@capgemini.com", "C");
		Users defaultUser3 = new Users(03, "Prabhleen", "prabhleen123", 7891848489L, "bharat.shah@capgemini.com", "A");
		Users defaultUser4 = new Users(04, "Monica", "monica123", 7891848489L, "bharat.shah@capgemini.com", "C");
		Users defaultUser5 = new Users(05, "Prabhnoor Kaur", "prabhnoor123", 7891848489L, "bharat.shah@capgemini.com", "C");
		
		usersData.put(defaultUser1.getUserId(), defaultUser1);
		usersData.put(defaultUser2.getUserId(), defaultUser2);
		usersData.put(defaultUser3.getUserId(), defaultUser3);
		usersData.put(defaultUser4.getUserId(), defaultUser4);
		usersData.put(defaultUser5.getUserId(), defaultUser5);
	}
	
	@Override
    public Users addUser(Users u) {
       
    	if (u != null) {
    		usersData.put(u.getUserId(),u);
    		return u;
    	}
    	else {
    		return null;
    	}
    }

    @Override
    public Users viewUser(int userId) {
        
    	Users u = null;
    	u = usersData.get(userId);
    	return u;
    }

    @Override
    public List<Users> viewAllUser() {
    	
        Users u = null;
        List<Users> lists = new ArrayList<>();
        
       	for(Integer userId : usersData.keySet()) {
       		u = usersData.get(userId);
       		lists.add(u);
       	}
       	return lists;
    }

    @Override
    public Users updateUser(Users u) {
		 
    	if (u != null) {
    		usersData.put(u.getUserId(),u);
    		return u;
    	}
    	else {
    		return null;
    	}

    }

    @Override
    public void deleteUser(int userId) {
       
    	usersData.remove(userId);
    }
    
    @Override
    public Users validate(int uid, String pass) {
        Users u = null;
        try {
			u = usersData.get(uid);
			if (pass.equals(u.getUserPassword())) {
				return u;
			}
			else {
				return null;
			}
		} catch (NullPointerException e) {
			return null;
		}
    }
    
    
}