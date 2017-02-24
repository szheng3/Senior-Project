package com.springUsersAccess.delegate;

import java.sql.SQLException;

import com.springUsersAccess.service.usernames.UsernameService;
import com.springUsersAccess.service.users.authentication.AuthenticationService;

/**
 * Created by Alex Almanza on 1/31/17.
 *
 * A 'business delegate' encapsulating the 'application services' needed for user authentication.
 *
 * http://corej2eepatterns.com/Patterns2ndEd/BusinessDelegate.htm
 * http://corej2eepatterns.com/Patterns2ndEd/ApplicationService.htm
 * http://stackoverflow.com/questions/14405919/business-delegate-vs-service-locator
 */
public class LoginDelegate {
    // Deceleration of services used, exact implementations are defined as spring beans in loginapp-config.xml
    private AuthenticationService authenticationService;
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private PassHashDelegate passHashDelegate;
    public void setPassHashDelegate(PassHashDelegate passHashDelegate) {
        this.passHashDelegate = passHashDelegate;
    }

    private UsernameService usernameService;
    public void setUsernameService(UsernameService usernameService) {
        this.usernameService = usernameService;
    }
    // end of service decelerations


    public boolean isValidUser(String username, String plaintext_password) throws SQLException {
        System.out.print("Attempting to verify user: " + username + '\n');
        System.out.print("Plaintext password: " + plaintext_password + '\n');

        // Check that a record for the username exists
        if (usernameService.usernameIsTaken(username)) {
            byte[] salt = authenticationService.getSalt(username);
            String hashed_password = passHashDelegate.saltedHash(salt, plaintext_password);
            System.out.print("Hashed: " + hashed_password + '\n');
            return authenticationService.isValidUser(username, hashed_password);
        }
        System.out.print("No record of user" + '\n');
        return false;
    }


}

