package com.springUsersAccess.service.passwords.creation;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/16/17.
 */
public interface NewPasswordService {
    int storeSaltHashPair(byte[] salt, String hashed_password) throws SQLException;
}
