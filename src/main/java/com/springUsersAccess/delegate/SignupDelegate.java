package com.springUsersAccess.delegate;

import com.springUsersAccess.service.creation.passwords.hashed.HashingService;
import com.springUsersAccess.service.creation.passwords.strength.StrengthService;
import com.springUsersAccess.service.creation.salt.SaltGenService;
import com.springUsersAccess.service.creation.users.HashedUserGenService;
import com.springUsersAccess.service.creation.usernames.UsernameService;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Alex Almanza on 2/4/17.
 */
public class SignupDelegate {
    // Deceleration of services to be used, exact implementations are defined as spring beans in signupapp-config.xml
    private HashedUserGenService hashedUserGenService;
    public void setHashedUserGenService(HashedUserGenService hashedUserGenService) {
        this.hashedUserGenService = hashedUserGenService;
    }

    private SaltGenService saltGenService;
    public void setSaltGenService(SaltGenService saltGenService) {
        this.saltGenService = saltGenService;
    }

    private HashingService hashingService;
    public void setHashingService(HashingService hashingService) {
        this.hashingService = hashingService;
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


    public boolean isPasswordAllowed(String password) throws SQLException {
        return strengthService.checkStrength(password);
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

    public void createUser(String username, String plaintext_password) throws SQLException {
        if(!isUsernameAllowed(username)) {
            throw new IllegalArgumentException("Username is not unique: " + username);
        }
        // Create a hashed version of the plain text password
        byte[] salt = saltGenService.makeSalt();
        String hashed_password = hashingService.createHashedPassword(salt, plaintext_password);

        hashedUserGenService.createUser(username, salt, hashed_password);
        // TODO: remove after testing
        System.out.print(String.format("Account created: \n(username, plaintext, salt, hashed)\n(%s, %s, %s, %s)",
                username, plaintext_password, new String(Arrays.toString(salt)), hashed_password));
    }
}
