package com.jayway.uipattern.login;

import com.jayway.uipattern.model.BaseModel;
import com.jayway.uipattern.service.LoginService;

/**
 * Created by pererik on 12/10/15.
 */
public class LoginPresenter {

    private final LoginModel mModel;
    private final LoginView  mView;

    private boolean mSettingUsernameInProgress;
    private boolean mSettingPasswordInProgress;

    public LoginPresenter(LoginView view) {
        mModel = new LoginModel();
        mView = view;

        // Add listener to model
        mModel.addOnModelChangeListener(new BaseModel.OnModelChangeListener() {
            @Override
            public void onModelChange() {
                updateViewFromModel();
            }
        });
    }

    private void updateViewFromModel() {
        mView.setUsername(mModel.getUsername());
        mView.setPassword(mModel.getPassword());

        boolean invalid = mModel.isInvalid();
        mView.setInvalid(invalid);
    }

    public void onValidate(String username, String password) {
        mModel.setUsername(username);
        mModel.setPassword(password);

        if (LoginService.getService().validate(username, password)) {
            mModel.setInvalid(false);
            mView.showCountryList();
        } else {
            mModel.setInvalid(true);
        }
    }

    public void onClear() {
        mModel.setUsername("");
        mModel.setPassword("");
        mModel.setInvalid(false);
    }

    public void setUsername(String username) {
        if(mSettingUsernameInProgress){
            return;
        }

        mSettingUsernameInProgress = true;
        mModel.setUsername(username);
        mSettingUsernameInProgress = false;
    }

    public void setPassword(String password) {
        if(mSettingPasswordInProgress){
            return;
        }

        mSettingPasswordInProgress = true;
        mModel.setPassword(password);
        mSettingPasswordInProgress = false;
    }

    public interface LoginView {

        void showCountryList();

        void setInvalid(boolean invalid);

        void setPassword(String password);

        void setUsername(String username);
    }
}
