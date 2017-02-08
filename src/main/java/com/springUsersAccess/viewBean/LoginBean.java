package com.springUsersAccess.viewBean;

/**
 *
 * Created by Alex Almanza on 1/31/17.
 * This class serves as a means of transferring the information seen by the user and underlying program
 */
public class LoginBean {
    private String username;
    private String password;

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
