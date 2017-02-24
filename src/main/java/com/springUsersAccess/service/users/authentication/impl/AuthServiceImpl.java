package com.springUsersAccess.service.users.authentication.impl;

import java.sql.SQLException;

import com.springUsersAccess.dao.PasswordDao;
import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.users.authentication.AuthenticationService;

/**
 * Created by Alex Almanza on 1/31/17.
 * A class that uses the AuthenticationService interface to authenticate users. Authentication is performed by
 * UserDAO, but this service encapsulates the DAO to prevent unwanted alterations.
 */
public class AuthServiceImpl implements AuthenticationService {
    //
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private PasswordDao passwordDao;
    public void setPasswordDao(PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }
    //

    @Override
    public byte[] getSalt(String username) throws SQLException {
        return passwordDao.getSalt(userDao.getPasswordRef(username));
    }

    @Override
    public boolean isValidUser(String username, String hashed_password) throws SQLException {
        return hashed_password.equals(passwordDao.getHash(userDao.getPasswordRef(username)));
    }

}
