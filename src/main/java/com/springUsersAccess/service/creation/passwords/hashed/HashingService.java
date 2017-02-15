package com.springUsersAccess.service.creation.passwords.hashed;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface HashingService {
    String createHashedPassword(byte[] salt, String plaintext_password);
}
