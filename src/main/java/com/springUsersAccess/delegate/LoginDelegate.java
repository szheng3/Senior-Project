package com.springUsersAccess.delegate;

import java.sql.SQLException;

import com.springUsersAccess.service.AuthenticationService;

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
    private AuthenticationService authenticationService;

    public AuthenticationService getAuthenticationService() {
        return this.authenticationService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public boolean isValidUser(String username, String password) throws SQLException {
        return authenticationService.isValidUser(username, password);
    }

}

