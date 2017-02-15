package com.springUsersAccess.service.creation.users.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.creation.users.HashedUserGenService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements HashedUserGenService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(String username, byte[] salt, String hashed_password) throws SQLException {
        if (userDao.isUsernameTaken(username)) {
            throw new IllegalArgumentException("Cant add a username that is already taken: " + username);
        }

        userDao.addUser(username, salt, hashed_password);
    }
}
