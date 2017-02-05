package com.springUsersAccess.service.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.UsernameService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/5/17.
 */
public class NoDuplicateUsernameSerivce implements UsernameService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean usernameIsTaken(String username) throws SQLException {
        return userDao.isUsernameTaken(username);
    }

    @Override
    public String suggestUsername(String[] words) {
        // TODO: take an array of words and form a username not in the database
        throw new UnsupportedOperationException();
    }
}
