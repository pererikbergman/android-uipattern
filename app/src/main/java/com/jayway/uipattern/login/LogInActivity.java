package com.jayway.uipattern.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jayway.uipattern.R;
import com.jayway.uipattern.list.CountriesActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mUsernameTextInputLayout;
    private EditText        mUsernameTextInput;
    private TextInputLayout mPasswordTextInputLayout;
    private EditText        mPasswordTextInput;
    private Button          mClearButton;
    private Button          mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mUsernameTextInputLayout = (TextInputLayout) findViewById(R.id.username_text_input_layout);
        mUsernameTextInput = (EditText) findViewById(R.id.username_text_input);
        mPasswordTextInputLayout = (TextInputLayout) findViewById(R.id.password_text_input_layout);
        mPasswordTextInput = (EditText) findViewById(R.id.password_text_input);
        mClearButton = (Button) findViewById(R.id.clear_button);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CountriesActivity.class));
            }
        });
    }

}
