package com.springUsersAccess.service.impl;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import java.sql.SQLException;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.UserService;

/**
 * A class that uses the UserService interface to authenticate users. Authentication is performed by
 * UserDAO, but this service encapsulates the DAO to prevent unwanted alterations.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        return userDao.isStoredUser(username, password);
    }

}
