package com.springUsersAccess.service.users.creation.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.users.creation.NewUserService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements NewUserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(String username, String hashed_password) throws SQLException {
//        if (userDao.isUsernameTaken(username)) {
//            throw new IllegalArgumentException("Cant add a username that is already taken: " + username);
//        }
        userDao.addPassword(username, hashed_password);
    }
}
