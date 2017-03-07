package com.springUsersAccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.springUsersAccess.dao.UserDao;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Alex Almanza on 1/31/17.
 */
public class UserDaoSQL implements UserDao {

    private DriverManagerDataSource dataSource ;
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUsernameTaken(String username) throws SQLException {
         String query = "Select count(*) from user where username = ?";

         try (Connection connection = dataSource.getConnection();
              PreparedStatement pstmt = connection.prepareStatement(query)) {

             pstmt.setString(1, username);
             try (ResultSet resultSet = pstmt.executeQuery()) {
                 resultSet.next(); // assumes there will be a result set
                 return (resultSet.getInt(1) > 0);
             }
         }
    }

    @Override
    public void reserveUsername(String username) throws SQLException {
        String query = "INSERT INTO user (username) VALUES (?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void addUser(String username, int password_ref) throws SQLException{
        // Only adds the new user if the user name isn't already taken
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("A record for that username already exists: " + username);
        }

        String query = "INSERT INTO user (username, password_ref) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setInt(2, password_ref);
            pstmt.executeUpdate();
        }
    }

    @Override
    public int getPasswordRef(String username) throws SQLException {
        String query = "Select password_ref from user where username = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, username);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                resultSet.next(); // assumes there will be a result set
                return resultSet.getInt(1);
            }
        }
    }
}
