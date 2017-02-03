package com.springUsersAccess.delegate;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import java.sql.SQLException;

import com.springUsersAccess.service.UserService;

/**
 * A 'buisness delagate' encapsulating the 'application services' needed for user authentication.
 *
 * http://corej2eepatterns.com/Patterns2ndEd/BusinessDelegate.htm
 * http://corej2eepatterns.com/Patterns2ndEd/ApplicationService.htm
 * http://stackoverflow.com/questions/14405919/business-delegate-vs-service-locator
 */
public class LoginDelegate {
    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isAuthenticUser(String username, String password) throws SQLException {
        return userService.isValidUser(username, password);
    }

}

