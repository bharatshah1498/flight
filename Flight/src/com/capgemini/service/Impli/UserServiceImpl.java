package com.capgemini.service.Impli;

import com.capgemini.dao.Impli.UserDaoImpl;
import com.capgemini.dao.Interface.IUserDao;
import com.capgemini.entities.Users;
import com.capgemini.exception.IncorrectArgumentException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.service.Interface.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDao dao = new UserDaoImpl();

    public UserServiceImpl(UserDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public Users addUser(Users u) {
        if (u != null) {
            return dao.addUser(u);
        } else {
            throw new UserNotFoundException("User is null");
        }
    }

    @Override
    public Users viewUser(int userId) {
        if (userId > 0) {
            return dao.viewUser(userId);
        } else {
            throw new IncorrectArgumentException("Invalid userId ");
        }

    }

    @Override
    public List<Users> viewAllUser() {

        List<Users> list = dao.viewAllUser();
        return list;
    }

    @Override
    public Users updateUser(Users u) {
        if (u != null) {
            return dao.updateUser(u);
        } else {
            throw new UserNotFoundException("User is null");
        }
    }

    @Override
    public void deleteUser(int userId) {
        if (userId > 0) {
            dao.deleteUser(userId);
        } else {
            throw new IncorrectArgumentException("Invalid UserId");
        }
    }

    @Override
    public Users validateUser(int uid, String pass) {
        UserDaoImpl dao = new UserDaoImpl();
        if (uid < 0 || pass.isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        } else {
            return dao.validate(uid, pass);
        }
    }
}

