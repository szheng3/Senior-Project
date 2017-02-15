package com.springUsersAccess.delegate;

import com.springUsersAccess.service.passwords.hash.HashingService;
import com.springUsersAccess.service.passwords.salt.SaltGenService;

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/15/17.
 */
public class PassHashDelegate {

    private SaltGenService saltGenService;
    public void setSaltGenService(SaltGenService saltGenService) {
        this.saltGenService = saltGenService;
    }

    private HashingService hashingService;
    public void setHashingService(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    public byte[] makeSalt(String username) throws SQLException {
        return saltGenService.makeSalt(username);
    }

    public String createHashedPassword(String username, String text) throws SQLException{
        return hashingService.createHashedPassword(username, text);
    }
}
