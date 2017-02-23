package com.springUsersAccess.service.passwords.salt.impl;

import com.springUsersAccess.service.passwords.salt.SaltGenService;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements SaltGenService {

    @Override
    public byte[] generateSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        System.out.println("New salt created: ");
        System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(salt));    //DEBUG PRINTF
        return salt;
    }
}
