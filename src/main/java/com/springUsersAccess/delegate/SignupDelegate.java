package com.springUsersAccess.delegate;

import com.springUsersAccess.service.NewUserService;
import com.springUsersAccess.service.PasswordService;
import com.springUsersAccess.service.UsernameService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 */
public class SignupDelegate {
    // Deceleration of services to be used, exact implementations are defined as spring beans in signupapp-config.xml
    private NewUserService newUserService;
    public void setNewUserService(NewUserService newUserService) {
        this.newUserService = newUserService;
    }

    private PasswordService passwordService;
    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    private UsernameService usernameService;
    public void setUsernameService(UsernameService usernameService) {
        this.usernameService = usernameService;
    }
    // end of service decelerations


    public boolean isPasswordAllowed(String password) throws SQLException {
        return passwordService.passwordIsStrong(password);
    }

    // TODO: Convey why the username is not allowed, which rule was broken
    public boolean isUsernameAllowed(String username) throws SQLException {
        // Check if the password has the proper format
        if (usernameService.checkFormat(username)) {
            // Format was OK, allow the username if not already taken
            return !usernameService.usernameIsTaken(username);
        }
        else {
            return false;
        }
    }

    public void createUser(String username, String password) throws SQLException {
        if(!isUsernameAllowed(username)) {
            throw new IllegalArgumentException("Username is not unique: " + username);
        }
        newUserService.createUser(username, password);
    }
}
