package com.springUsersAccess.delegate;

import com.springUsersAccess.service.NewUserService;
import com.springUsersAccess.service.PasswordService;
import com.springUsersAccess.service.UsernameService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 */
public class SignupDelegate {
    private NewUserService newUserService;
    private PasswordService passwordService;
    private UsernameService usernameService;



    public void setNewUserService(NewUserService newUserService) {
        this.newUserService = newUserService;
    }
    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    public void setUsernameService(UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    public boolean isPasswordAllowed(String password) throws SQLException {
        return passwordService.passwordIsStrong(password);
    }

    public boolean isUsernameAllowed(String username) throws SQLException {
        return this.usernameService.usernameIsTaken(username);
    }

    public void createUser(String username, String password) throws SQLException {
        if(!isUsernameAllowed(username)) {
            throw new IllegalArgumentException("Username is not unique: " + username);
        }
        newUserService.createUser(username, password);
    }
}
