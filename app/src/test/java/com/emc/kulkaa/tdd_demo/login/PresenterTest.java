package com.emc.kulkaa.tdd_demo.login;

import com.emc.kulkaa.tdd_demo.LoginPresenter;
import com.emc.kulkaa.tdd_demo.LoginView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kulkaa on 2/8/2018.
 */

public class PresenterTest {
    @Test
    public void checkIfLoginAttemptIsExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkIfLoginAttemptIsNotExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkUsernameAndPasswordIsCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("ajay","demotdd");
        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkUsernameAndPasswordIsInCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        verify(loginView).showErrorMessageForUserNamePassword();
    }

    @Test
    public void checkIfLoginAttemptIsExceededAndViewMethodCalled()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("abc","detdd");
        loginPresenter.doLogin("qwexyz","dtdd");
        loginPresenter.doLogin("pqrxyz","demtdd");
        verify(loginView).showErrorMessageForMaxLoginAttempt();
    }
}
