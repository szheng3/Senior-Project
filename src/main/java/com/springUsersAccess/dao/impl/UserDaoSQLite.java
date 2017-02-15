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
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


public class UserDaoSQLite implements UserDao {

    private SingleConnectionDataSource dataSource ;
    public void setDataSource(SingleConnectionDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUsernameTaken(String username) throws SQLException {
         try (Connection connection = dataSource.getConnection()) {
             String query = "Select count(1) from user where username = ?";
             PreparedStatement pstmt = connection.prepareStatement(query);
             pstmt.setString(1, username);
             ResultSet resultSet = pstmt.executeQuery();
             if (resultSet.next())
                 return (resultSet.getInt(1) > 0);
             else
                 // TODO: decide if an exception should be thrown when there is no result set available
                 return false;
         }
    }

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT count(1) FROM main.user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next())
                return (resultSet.getInt(1) > 0);
            else
                // TODO: decide if an exception should be thrown when there is no result set available
                return false;
        }
    }

    @Override
    public void addUser(String username, String password) throws SQLException{
        // Only adds the new user if the user name isnt already taken
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("A record for that username already exists: " + username);
        }

        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void addUser(String username, byte[] salt, String hashed_password) throws SQLException{
        // Only adds the new user if the user name isnt already taken
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("A record for that username already exists: " + username);
        }

        String query = "INSERT INTO user (username, password, salt) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashed_password);
            pstmt.setBytes(3, salt);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void addUser(String username, byte[] salt) throws SQLException{
        // Only adds the new user if the user name isnt already taken
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("A record for that username already exists: " + username);
        }

        String query = "INSERT INTO user (username, salt) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setBytes(2, salt);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void updateSalt(String username, byte[] salt) throws SQLException {
        throw new UnsupportedOperationException("Cannot safely change salt yet. Need to be sure password is hased to the new salt.");
//        String updateSQL = "UPDATE user "
//                + "SET salt = ? "
//                + "WHERE username=?";
//
//            try (Connection conn = dataSource.getConnection();
//                 PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
//            // set parameters
//            pstmt.setBytes(1, salt);
//            pstmt.setString(2, username);
//            pstmt.executeUpdate();
//            System.out.println("Stored Salt in database.");
//        }
    }

    @Override
    public byte[] getSalt(String username) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT salt FROM main.user WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                byte[] salt = resultSet.getBytes(1);
                return salt;
            }
            throw new IllegalArgumentException("No salt has been given to this user: " + username);
        }
    }

    @Override
    public String changePassword(String username, String password_current, String password_new) throws SQLException {
        // TODO: Implement password changes
        throw new UnsupportedOperationException("Password changes not yet implemented.");
    }
}
