package com.springUsersAccess.service;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 * A service for creating new users
 */
public interface NewUserService {
    void createUser(String username, String password) throws SQLException;
}
