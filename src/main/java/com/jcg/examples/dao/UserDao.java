package com.jcg.examples.dao;

import java.sql.SQLException;

/**
 * This is an interface for 'data access objects' involving the 'user' table of our database.
 */
public interface UserDao {
    public boolean isValidUser(String username, String password) throws SQLException;

}
