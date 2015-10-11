package com.jayway.uipattern.login;

import com.jayway.uipattern.service.LoginService;

/**
 * Created by pererik on 12/10/15.
 */
public class LoginController {

    private final LoginModel mModel;
    private final LoginView  mView;

    private boolean mSettingUsernameInProgress;
    private boolean mSettingPasswordInProgress;

    public LoginController(LoginModel model, LoginView view) {
        mModel = model;
        mView = view;
        mView.setOnViewListener(new LoginActivity.OnViewListener() {
            @Override
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

            @Override
            public void onClear() {
                mModel.setUsername("");
                mModel.setPassword("");
                mModel.setInvalid(false);
            }

            @Override
            public void setUsername(String username) {
                if (mSettingUsernameInProgress) {
                    return;
                }

                mSettingUsernameInProgress = true;
                mModel.setUsername(username);
                mSettingUsernameInProgress = false;
            }

            @Override
            public void setPassword(String password) {
                if (mSettingPasswordInProgress) {
                    return;
                }

                mSettingPasswordInProgress = true;
                mModel.setPassword(password);
                mSettingPasswordInProgress = false;
            }
        });
    }

    public interface LoginView {

        void setOnViewListener(LoginActivity.OnViewListener object);

        void showCountryList();

    }
}
