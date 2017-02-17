package com.springUsersAccess.dao;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/16/17.
 */
public interface PasswordDao {
    int addSaltHashPair(byte[] salt, String hashed_password) throws SQLException;
    byte[] getSalt(int id) throws SQLException;
    String getHash(int id) throws SQLException;
}
