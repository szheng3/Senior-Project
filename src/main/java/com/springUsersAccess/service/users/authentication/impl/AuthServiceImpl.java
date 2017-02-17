package com.springUsersAccess.service.users.authentication.impl;

import java.sql.SQLException;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.users.authentication.AuthenticationService;

/**
 * Created by Alex Almanza on 1/31/17.
 * A class that uses the AuthenticationService interface to authenticate users. Authentication is performed by
 * UserDAO, but this service encapsulates the DAO to prevent unwanted alterations.
 */
public class AuthServiceImpl implements AuthenticationService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isValidUser(String username, String hashed_password) throws SQLException {
        return userDao.isValidUser(username, hashed_password);
    }

}
