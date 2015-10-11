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
import com.jayway.uipattern.model.BaseModel;

public class LoginActivity extends AppCompatActivity implements LoginController.LoginView {

    private TextInputLayout mUsernameTextInputLayout;
    private EditText        mUsernameTextInput;
    private TextInputLayout mPasswordTextInputLayout;
    private EditText        mPasswordTextInput;
    private Button          mClearButton;
    private Button          mLoginButton;

    private OnViewListener mViewListener;

    private LoginModel                mLoginModel;
    private LoginController           mLoginController;
    private LoginController.LoginView mLoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Setting up the model.
        mLoginModel = new LoginModel();

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
        mLoginController = new LoginController(mLoginModel, mLoginView);

        // Setting up the interaction to the controller.
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewListener.onValidate(
                        mUsernameTextInput.getText().toString(),
                        mPasswordTextInput.getText().toString()
                );
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewListener.onClear();
            }
        });

        mUsernameTextInput.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mViewListener.setUsername(s.toString());
            }
        });

        mPasswordTextInput.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mViewListener.setPassword(s.toString());
            }
        });

        // Add listener to model
        mLoginModel.addOnModelChangeListener(new BaseModel.OnModelChangeListener() {
            @Override
            public void onModelChange() {
                updateViewFromModel();
            }
        });
    }

    private void updateViewFromModel() {
        mUsernameTextInput.setText(mLoginModel.getUsername());
        mUsernameTextInput.setSelection(mLoginModel.getUsername().length());
        mPasswordTextInput.setText(mLoginModel.getPassword());
        mPasswordTextInput.setSelection(mLoginModel.getPassword().length());

        boolean invalid = mLoginModel.isInvalid();
        if (invalid) {
            mUsernameTextInputLayout.setError("Username required");
            mPasswordTextInputLayout.setError("Password required");
        } else {
            mUsernameTextInputLayout.setError(null);
            mPasswordTextInputLayout.setError(null);
        }
    }

    /* LoginView */

    public void showCountryList() {
        startActivity(new Intent(LoginActivity.this, ListActivity.class));
    }

    public void setOnViewListener(OnViewListener viewListener) {
        mViewListener = viewListener;
    }

    /* Listener Interface */

    public interface OnViewListener {
        void onValidate(String username, String password);

        void onClear();

        void setUsername(String username);

        void setPassword(String password);
    }

}
