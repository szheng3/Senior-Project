package com.springUsersAccess.service.passwords.strength.impl;

import com.springUsersAccess.service.passwords.strength.StrengthService;

/**
 * Created by Alex Almanza on 2/5/17.
 */
public class AllowAllPasswordsService implements StrengthService {
    @Override
    public boolean checkStrength(String password) {
        return true;
    }
}
