package com.springUsersAccess.delegate;

import com.springUsersAccess.service.HashAuthenticationService;

/**
 * Created by Alex Almanza on 2/4/17.
 *
 * THis calls the service for password hashing
 */
public class HashPassDelegate {
    private HashAuthenticationService hashPassService;

    public HashAuthenticationService getHashPassService() {
        return hashPassService;
    }

    public void setHashPassService(HashAuthenticationService hashPassService) {
        this.hashPassService = hashPassService;
    }



}
