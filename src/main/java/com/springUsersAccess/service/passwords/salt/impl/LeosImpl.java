package com.springUsersAccess.service.passwords.salt.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.passwords.salt.SaltGenService;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements SaltGenService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public byte[] makeSalt(String username) throws SQLException {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(salt));    //DEBUG PRINTF
        userDao.addUser(username, salt);
        return salt;
    }
}
