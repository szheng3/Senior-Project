package com.springUsersAccess.service.users.authentication;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import java.sql.SQLException;

/**
 * This interface is for 'application services', which serve to separate operations involving a database from the
 * underlying implementation of those operations. Basically, it insulates the alteration of the database from the user.
 *
 * http://corej2eepatterns.com/Patterns2ndEd/ApplicationService.htm
 */
public interface AuthenticationService {
    byte[] getSalt(String username) throws SQLException;
    boolean isValidUser(String username, String hashed_password) throws SQLException;
}
