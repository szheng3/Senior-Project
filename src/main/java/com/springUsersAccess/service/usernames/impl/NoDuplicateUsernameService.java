package com.springUsersAccess.service.usernames.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.usernames.UsernameService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/5/17.
 */
public class NoDuplicateUsernameService implements UsernameService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean usernameIsTaken(String username) throws SQLException {
        return userDao.isUsernameTaken(username);
    }

    @Override
    public String suggestUsername(String[] words) {
        // TODO: take an array of words and form a username not in the database
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkFormat(String username) {
        // Don't allow blank usernames
        if (username == null) return false;   // checks if null
        if(username.isEmpty()) return false;  // checks if empty string

        /*
            Taken from stack overflow:
            http://stackoverflow.com/questions/12018245/regular-expression-to-validate-username

            Rules:
                1) Only contains alphanumeric characters, underscore and dot.

                2) Underscore and dot can't be at the end or start of a username
                        (e.g _username / username_ / .username / username.).

                3) Underscore and dot can't be next to each other
                        (e.g user_.name).

                4) Underscore or dot can't be used multiple times in a row
                        (e.g user__name / user..name).

                5) Number of characters must be between 8 to 20.


            ^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$
             └─────┬────┘└───┬──┘└─────┬─────┘└─────┬─────┘ └───┬───┘
                   │         │         │            │           no _ or . at the end
                   │         │         │            │
                   │         │         │            allowed characters
                   │         │         │
                   │         │         no __ or _. or ._ or .. inside
                   │         │
                   │         no _ or . at the beginning
                   │
                   username is 8-20 characters long
         */

        // Check pattern
        String rules = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        return username.matches(rules);
    }
}
