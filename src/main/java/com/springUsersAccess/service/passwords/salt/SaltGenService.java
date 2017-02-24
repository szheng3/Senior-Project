package com.springUsersAccess.service.passwords.salt;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface SaltGenService {
    // Username should be included to insure what ever salt is created for the user gets stored on record
    byte[] generateSalt();
}
