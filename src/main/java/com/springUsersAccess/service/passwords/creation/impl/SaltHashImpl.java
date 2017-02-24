package com.springUsersAccess.service.passwords.creation.impl;

import com.springUsersAccess.dao.PasswordDao;
import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.passwords.creation.NewPasswordService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/16/17.
 */
public class SaltHashImpl implements NewPasswordService{
    private PasswordDao passwordDao;
    public void setPasswordDao(PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }

    @Override
    public int storeSaltHashPair(byte[] salt, String hashed_password) throws SQLException {
        return passwordDao.addSaltHashPair(salt, hashed_password);
    }
}
