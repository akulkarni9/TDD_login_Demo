package com.emc.kulkaa.tdd_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

public class TestLoginActivity extends AppCompatActivity implements LoginView{

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_login_main);

        initializePresenter();
        initializeViews();
    }

    private void initializeViews() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(edtUserName.getText().toString().trim(), edtPassword.getText().toString().trim());
            }
        });
    }

    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }


    @Override
    public void showErrorMessageForUserNamePassword() {
        Snackbar.make(edtPassword, "Please check Username or Password.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin, "You have exceeded MAXIMUM attempts.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login successful.", Snackbar.LENGTH_LONG).show();
    }
}
