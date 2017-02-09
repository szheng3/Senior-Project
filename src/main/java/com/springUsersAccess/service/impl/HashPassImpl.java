package com.springUsersAccess.service.impl;

import com.springUsersAccess.service.HashAuthenticationService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import java.util.Arrays;
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
        char[] pwChar = password.toCharArray();
        byte[] salt = makeSalt();
        PBEKeySpec spec = new PBEKeySpec(pwChar, salt, 10000, 256);
        Arrays.fill(pwChar, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            //TODO Stroe Salt to each User's DB tuple.

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

    @Override
    public byte[] makeSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(salt));    //DEBUG PRINTF
        return salt;
    }

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        return false;
    }

}
