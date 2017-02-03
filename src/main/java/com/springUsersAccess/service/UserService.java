package com.springUsersAccess.service;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import java.sql.SQLException;

/**
 * This interface is for 'application services', which serve to seperate operations involving a database from the
 * underlaying implementation of those operations. Basically, it incapsulate the alteration of the database
 *
 * http://corej2eepatterns.com/Patterns2ndEd/ApplicationService.htm
 */
public interface UserService {
    public boolean isValidUser(String username, String password) throws SQLException;

}
