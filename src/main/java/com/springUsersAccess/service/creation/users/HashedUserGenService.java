package com.springUsersAccess.service.creation.users;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface HashedUserGenService {
    void createUser(String username, byte[] salt, String hashed_password) throws SQLException;
}
