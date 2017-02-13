package com.springUsersAccess.dao.impl;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.springUsersAccess.dao.UserDao;


public class UserDaoSQLite implements UserDao {
    private DataSource dataSource ;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        connection = null;
    }

    // SQLite can only be accessed via one connection, which is why it is static
    private static Connection connection;
    private Connection getConnection() throws SQLException{
        if (connection == null) connection = dataSource.getConnection();
        return connection;
    }

    @Override
    public boolean isUsernameTaken(String username) throws SQLException {
        String query = "Select count(1) from user where username = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, username);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next())
            return (resultSet.getInt(1) > 0);
        else
            return false;
    }

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        String query = "Select count(1) from main.user where username = ? and password = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next())
            return (resultSet.getInt(1) > 0);
        else
            return false;
    }

    @Override
    public void addUser(String username, String password) throws SQLException{
        // Only adds the new user if the user name isnt already taken
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("A record for that username already exists: " + username);
        }

        String query = "INSERT INTO user (" +
                "username, " +
                "password) VALUES (" +
                "?, ?)";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.executeUpdate();
    }

    @Override
    public String getSalt(String username) throws SQLException {
        // TODO: Implement salt in database
        throw new UnsupportedOperationException("User entities currently do not store password hash salt.");
    }

    @Override
    public String changePassword(String username, String password_current, String password_new) throws SQLException {
        // TODO: Implement password changes
        throw new UnsupportedOperationException("Password changes not yet implemented.");
    }
}
