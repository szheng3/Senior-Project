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
    public void createUser(String username, int password_ref) throws SQLException {
        userDao.addUser(username, password_ref);
    }
}
