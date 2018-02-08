package com.emc.kulkaa.tdd_demo;

/**
 * Created by kulkaa on 2/8/2018.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginView loginView;
    private int loginAttempt;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public int incrementLoginAttempt() {
        loginAttempt += 1;
        return loginAttempt;
    }

    public void resetLoginAttempt() {
        loginAttempt = 0;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }


    public void doLogin(String userName, String password) {
        if (isLoginAttemptExceeded()) {
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if (userName.equals("ajay") && password.equals("demotdd")) {
            loginView.showLoginSuccessMessage();
            resetLoginAttempt();
            return;
        }

        // increment login attempt only if it's fail
        incrementLoginAttempt();
        loginView.showErrorMessageForUserNamePassword();
    }

}
