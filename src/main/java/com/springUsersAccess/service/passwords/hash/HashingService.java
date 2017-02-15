package com.springUsersAccess.service.passwords.hash;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface HashingService {
    String createHashedPassword(byte[] salt, String plaintext_password);
}
