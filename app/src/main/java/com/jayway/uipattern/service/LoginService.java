package com.jayway.uipattern.service;

/**
 * Created by pererik on 12/10/15.
 */
public class LoginService {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password){
        if(!USERNAME.equals(username)){
            return false;
        }

        if(!PASSWORD.equals(password)){
            return false;
        }

        return true;
    }

    public static LoginService getService() {
        return new LoginService();
    }

}
