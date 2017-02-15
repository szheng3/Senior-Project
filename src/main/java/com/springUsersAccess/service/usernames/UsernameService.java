package com.springUsersAccess.service.usernames;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/5/17.
 */
public interface UsernameService {
    boolean usernameIsTaken(String username) throws SQLException;
    String suggestUsername(String[] words);
    boolean checkFormat(String username);
}
