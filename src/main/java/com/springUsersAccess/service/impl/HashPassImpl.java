package com.springUsersAccess.service.impl;

import com.springUsersAccess.service.HashAuthenticationService;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.SecureRandom;
import java.sql.SQLException;

import java.util.Random;



/**
 * Created by Leo on 2/8/2017.
 */
public class HashPassImpl implements HashAuthenticationService {

    @Override
    public String getHashedPassword(String username) throws SQLException {
        return null;
    }

    @Override
    public String createHashedPassword(String username, String password) {
        return null;
    }

    @Override
    public String makeSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        String strSalt = org.apache.commons.codec.binary.Base64.encodeBase64String(salt);
        return strSalt;
    }

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        return false;
    }

}
