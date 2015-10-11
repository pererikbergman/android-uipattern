package com.jayway.uipattern.login;

import com.jayway.uipattern.model.BaseModel;

/**
 * Created by pererik on 12/10/15.
 */
public class LoginModel extends BaseModel {

    private String  mUsername = "username";
    private String  mPassword = "password";
    private boolean mInvalid  = false;

    public LoginModel() {

    }

    public String getUsername() {
        return mUsername;
    }

    public LoginModel setUsername(String username) {
        mUsername = username;
        notifyChange();

        return this;
    }

    public String getPassword() {
        return mPassword;
    }

    public LoginModel setPassword(String password) {
        mPassword = password;
        notifyChange();

        return this;
    }

    public boolean isInvalid() {
        return mInvalid;
    }

    public LoginModel setInvalid(boolean invalid) {
        mInvalid = invalid;
        notifyChange();

        return this;
    }

}
