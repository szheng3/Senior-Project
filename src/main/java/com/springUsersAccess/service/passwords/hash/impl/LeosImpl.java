package com.springUsersAccess.service.passwords.hash.impl;

import com.springUsersAccess.dao.UserDao;
import com.springUsersAccess.service.passwords.hash.HashingService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements HashingService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String createHashedPassword(String username, String plaintext_password) throws SQLException{
        char[] pwChar = plaintext_password.toCharArray();
        byte[] salt = userDao.getSalt(username);
        PBEKeySpec spec = new PBEKeySpec(pwChar, salt, 10000, 256);
        Arrays.fill(pwChar, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return org.apache.commons.codec.binary.Base64.encodeBase64String(skf.generateSecret(spec).getEncoded());
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        } catch (InvalidKeySpecException ivkse) {
            ivkse.printStackTrace();
        } finally {
            spec.clearPassword();
        }
        System.out.println("Creating Hashed PW failed.");   //DEBUG PRINTF
        return null;
    }
}
