package com.emc.kulkaa.tdd_demo.login;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.emc.kulkaa.tdd_demo.R;
import com.emc.kulkaa.tdd_demo.TestLoginActivity;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by kulkaa on 2/8/2018.
 */

public class LoginTest {

    ActivityTestRule<TestLoginActivity> activityTestRule = new ActivityTestRule<>(TestLoginActivity.class);

    @Test
    public void checkUserNameEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPasswordEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginSuccess()
    {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("ajay"),closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText("demotdd"),closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login successful.")).check(matches(isDisplayed()));

    }


}
