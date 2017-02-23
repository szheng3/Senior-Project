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

    @Override
    public String saltedHash(byte[] salt, String plaintext_password) {
        char[] pwChar = plaintext_password.toCharArray();
        PBEKeySpec spec = new PBEKeySpec(pwChar, salt, 10000, 256);
        Arrays.fill(pwChar, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            System.out.println("Creating Hashed PW succeeded.");   //DEBUG PRINTF
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
