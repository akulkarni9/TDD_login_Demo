package com.emc.kulkaa.tdd_demo;

/**
 * Created by kulkaa on 2/8/2018.
 */

public interface LoginView {
    void showErrorMessageForUserNamePassword();

    void showErrorMessageForMaxLoginAttempt();

    void showLoginSuccessMessage();
}
