package com.jayway.uipattern.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jayway.uipattern.R;
import com.jayway.uipattern.help.SimpleTextWatcher;
import com.jayway.uipattern.list.ListActivity;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView {

    private TextInputLayout mUsernameTextInputLayout;
    private EditText        mUsernameTextInput;
    private TextInputLayout mPasswordTextInputLayout;
    private EditText        mPasswordTextInput;
    private Button          mClearButton;
    private Button          mLoginButton;

    private LoginPresenter           mLoginPresenter;
    private LoginPresenter.LoginView mLoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Setting up the view.
        mLoginView = this;

        mUsernameTextInputLayout = (TextInputLayout) findViewById(R.id.username_text_input_layout);
        mUsernameTextInput = (EditText) findViewById(R.id.username_text_input);
        mPasswordTextInputLayout = (TextInputLayout) findViewById(R.id.password_text_input_layout);
        mPasswordTextInput = (EditText) findViewById(R.id.password_text_input);
        mClearButton = (Button) findViewById(R.id.clear_button);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mUsernameTextInputLayout.setErrorEnabled(true);
        mPasswordTextInputLayout.setErrorEnabled(true);

        // Setting up the controller.
        mLoginPresenter = new LoginPresenter(mLoginView);

        // Setting up the interaction to the controller.
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.onValidate(
                        mUsernameTextInput.getText().toString(),
                        mPasswordTextInput.getText().toString()
                );
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.onClear();
            }
        });

        mUsernameTextInput.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mLoginPresenter.setUsername(s.toString());
            }
        });

        mPasswordTextInput.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mLoginPresenter.setPassword(s.toString());
            }
        });
    }

    /* LoginView */

    public void showCountryList() {
        startActivity(new Intent(LoginActivity.this, ListActivity.class));
    }

    public void setInvalid(boolean invalid) {
        if (invalid) {
            mUsernameTextInputLayout.setError("Username required");
            mPasswordTextInputLayout.setError("Password required");
        } else {
            mUsernameTextInputLayout.setError(null);
            mPasswordTextInputLayout.setError(null);
        }
    }

    public void setPassword(String password) {
        mPasswordTextInput.setText(password);
        mPasswordTextInput.setSelection(password.length());
    }

    public void setUsername(String username) {
        mUsernameTextInput.setText(username);
        mUsernameTextInput.setSelection(username.length());
    }
}
