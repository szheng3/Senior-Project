package com.springUsersAccess.service.creation.salt.impl;

import com.springUsersAccess.service.creation.salt.SaltGenService;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public class LeosImpl implements SaltGenService {
    @Override
    public byte[] makeSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(salt));    //DEBUG PRINTF
        return salt;
    }
}
