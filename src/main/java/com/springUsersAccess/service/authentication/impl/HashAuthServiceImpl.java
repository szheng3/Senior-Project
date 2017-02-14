package com.springUsersAccess.service.authentication.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.delegate.HashPassDelegate;
import com.springUsersAccess.service.authentication.AuthenticationService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 */
public class HashAuthServiceImpl implements AuthenticationService {

    private UserDao userDao;
    private HashPassDelegate hashPassDelegate;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public HashPassDelegate getHashPassDelegate() {
        return hashPassDelegate;
    }

    public void setHashPassDelegate(HashPassDelegate hashPassDelegate) {
        this.hashPassDelegate = hashPassDelegate;
    }

    @Override
    public boolean isValidUser(String username, String password_plaintext) throws SQLException {
        if (userDao.isUsernameTaken(username)) {
            // Hash the plaintext version of password w/ salt
            String salt = userDao.getSalt(username);
            // TODO: password hashing function
        }
        return false;
    }
}
