package com.springUsersAccess.service;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 *
 * This interface describes the methods used for hashing a password
 */
public interface HashAuthenticationService extends AuthenticationService {
    String getHashedPassword(String username) throws SQLException;
    String createHashedPassword(String username, String password);
    String makeSalt();
    boolean isValidUser(String username, String password) throws SQLException;
}
