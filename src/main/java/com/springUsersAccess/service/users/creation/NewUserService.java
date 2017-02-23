package com.springUsersAccess.service.users.creation;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface NewUserService {
    void createUser(String username, int password_ref) throws SQLException;
}
