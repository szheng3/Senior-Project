package com.springUsersAccess.service.impl;

import com.springUsersAccess.service.PasswordService;

/**
 * Created by Alex Almanza on 2/5/17.
 */
public class AllowAllPasswordsService implements PasswordService {
    @Override
    public boolean passwordIsStrong(String password) {
        return true;
    }
}
