package com.hector.pocmvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.hector.pocmvp.activity.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by hetorres on 2/17/16.
 */

@RunWith(AndroidJUnit4.class)
public class LoginFragmentEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void loginSuccess() {
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("hector"));

        onView(withId(R.id.password))
                .perform(typeText("123"));

        onView(withId(R.id.btn_sign_in))
                .perform(closeSoftKeyboard(), click());

        // Comparing results
        onView(withId(R.id.results))
                .check(matches(withText("Hector, Torres")));
    }

    @Test
    public void loginFail() {
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("oscar"));

        onView(withId(R.id.password))
                .perform(typeText("asdsasdaad"));

        onView(withId(R.id.btn_sign_in))
                .perform(closeSoftKeyboard(), click());

        // Comparing results
        onView(withId(R.id.results))
                .check(matches(withText("Fail!")));
    }
}
