package com.springUsersAccess.dao.impl;

import com.springUsersAccess.dao.PasswordDao;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

/**
 * Created by Alex Almanza on 2/16/17.
 */
public class PasswordDaoSQL implements PasswordDao {
    private DriverManagerDataSource dataSource ;
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addSaltHashPair(byte[] salt, String hashed_password) throws SQLException {
        String query = "INSERT INTO password (salt, hash) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setBytes(1, salt);
            pstmt.setString(2, hashed_password);
            pstmt.executeUpdate();
            try (ResultSet resultSet = pstmt.getGeneratedKeys()) {
                resultSet.next();
                return resultSet.getInt(1);
            }
        }
    }

    @Override
    public byte[] getSalt(int id) throws SQLException {
        String query = "SELECT salt FROM password WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                resultSet.next();
                return resultSet.getBytes(1);
            }
        }
    }

    @Override
    public String getHash(int id) throws SQLException {
        String query = "SELECT hash FROM password WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                resultSet.next();
                return resultSet.getString(1);
            }
        }
    }
}
