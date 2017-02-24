package com.springUsersAccess.service.passwords.hash;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/14/17.
 */
public interface HashingService {
    String saltedHash(byte[] salt, String plaintext_password);
}
