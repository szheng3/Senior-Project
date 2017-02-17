package com.springUsersAccess.delegate;

import com.springUsersAccess.service.passwords.strength.StrengthService;
import com.springUsersAccess.service.users.creation.NewUserService;
import com.springUsersAccess.service.usernames.UsernameService;

import java.sql.SQLException;
import java.util.Arrays;

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
    // end of service decelerations

    private PassHashDelegate passHashDelegate;
    public void setPassHashDelegate(PassHashDelegate passHashDelegate) {
        this.passHashDelegate = passHashDelegate;
    }


    public boolean isPasswordAllowed(String password) throws SQLException {
        return strengthService.checkStrength(password);
    }

    // TODO: Convey why the username is not allowed, which rule was broken
    public boolean isUsernameAvailable(String username) throws SQLException {
        return !usernameService.usernameIsTaken(username);
    }

    public boolean isFormatCorrect(String username) {
        return usernameService.checkFormat(username);
    }

    public void createUser(String username, String plaintext_password) throws SQLException {
        if(!isUsernameAvailable(username)) {
            throw new IllegalArgumentException("Username is not unique: " + username);
        }
        // Creates the username and gives it salt
        byte[] salt = passHashDelegate.makeSalt(username);
        String hashed_password = passHashDelegate.createHashedPassword(username, plaintext_password);

        newUserService.createUser(username, hashed_password);
        // TODO: remove after testing
        System.out.print(String.format("Account created: \n(username, plaintext, salt, hash)\n(%s, %s, %s, %s)",
                username, plaintext_password, new String(Arrays.toString(salt)), hashed_password));
    }
}
