package com.springUsersAccess.dao;

import java.sql.SQLException;

/**
 * This is an interface for 'data access objects' involving the 'user' table of our database.
 * By using this interface, different dialects/implementations can be used for performing the same
 * operations on the database
 */
public interface UserDao {
    boolean isUsernameTaken(String username) throws SQLException;
    void addUser(String username, int password_ref) throws SQLException;
    int getPasswordRef(String username) throws SQLException;
    void reserveUsername(String username) throws SQLException;
}
