package com.springUsersAccess.delegate;

import com.springUsersAccess.service.passwords.strength.StrengthService;
import com.springUsersAccess.service.users.creation.NewUserService;
import com.springUsersAccess.service.usernames.UsernameService;

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

    private StrengthService strengthService;
    public void setStrengthService(StrengthService strengthService) {
        this.strengthService = strengthService;
    }

    private UsernameService usernameService;
    public void setUsernameService(UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    private PassHashDelegate passHashDelegate;
    public void setPassHashDelegate(PassHashDelegate passHashDelegate) {
        this.passHashDelegate = passHashDelegate;
    }
    // end of service decelerations

    // Operations performed by delegate class

    public boolean isPasswordAllowed(String password) throws SQLException {
        return strengthService.checkStrength(password);
    }

    public boolean isUsernameAvailable(String username) throws SQLException {
        // TODO: Convey why the username is not allowed, which rule was broken
        return !usernameService.usernameIsTaken(username);
    }

    public boolean isFormatCorrect(String username) {
        return usernameService.checkFormat(username);
    }

    public void createUser(String username, String plaintext_password) throws SQLException {
        // TODO: remove checking of username availability
        if(!isUsernameAvailable(username)) {throw new IllegalArgumentException("Username is not unique: " + username);}

        // Securely stores the user's password, then creates a record for the username
        int password_ref = passHashDelegate.securelyStorePassword(plaintext_password);
        newUserService.createUser(username, password_ref);

    }
}
