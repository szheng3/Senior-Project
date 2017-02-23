package com.springUsersAccess.delegate;

import com.springUsersAccess.service.passwords.creation.NewPasswordService;
import com.springUsersAccess.service.passwords.hash.HashingService;
import com.springUsersAccess.service.passwords.salt.SaltGenService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/15/17.
 */
public class PassHashDelegate {
    //
    private SaltGenService saltGenService;
    public void setSaltGenService(SaltGenService saltGenService) {
        this.saltGenService = saltGenService;
    }

    private HashingService hashingService;
    public void setHashingService(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    private NewPasswordService newPasswordService;
    public void setNewPasswordService(NewPasswordService newPasswordService) {
        this.newPasswordService = newPasswordService;
    }
    //

    public byte[] generateSalt() {
        return saltGenService.generateSalt();
    }

    public String saltedHash(byte[] salt, String plaintext_password) {
        return hashingService.saltedHash(salt, plaintext_password);
    }

    public int securelyStorePassword(String plaintext_password) throws SQLException {
        byte[] salt = generateSalt();
        String hashed_password = saltedHash(salt, plaintext_password);
        int password_ref = newPasswordService.storeSaltHashPair(salt, hashed_password);
        return password_ref;
    }
}
