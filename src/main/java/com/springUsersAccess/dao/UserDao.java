package com.springUsersAccess.dao;

import java.sql.SQLException;

/**
 * This is an interface for 'data access objects' involving the 'user' table of our database.
 * By using this interface, different dialects/implementations can be used for performing the same
 * operations on the database
 */
public interface UserDao {
    boolean isUsernameTaken(String username) throws SQLException;
    boolean isValidUser(String username, String password) throws SQLException;
    void addUser(String username, String password) throws SQLException;
    void addUser(String username, byte[] salt, String hashed_password) throws SQLException;
    void updateSalt(String username, byte[] salt) throws SQLException;
    byte[] getSalt(String username) throws SQLException;
    String changePassword(String username, String password_current, String password_new) throws SQLException;
}
