package com.springUsersAccess.service.creation.passwords.hashed.impl;

import com.springUsersAccess.service.creation.passwords.hashed.HashingService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements HashingService {
    @Override
    public String createHashedPassword(byte[] salt , String password) {
        char[] pwChar = password.toCharArray();
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
