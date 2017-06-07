package za.co.dvt.android.showcase.ui;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.co.dvt.android.showcase.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainNavigationActivityTest {

    @Rule
    public ActivityTestRule<MainNavigationActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainNavigationActivity.class);


    @Test
    public void aboutClicked_ShowsAboutPage() {

        onView(withId(R.id.navigation_about)).perform(click());

        onView(withText("about")).check(matches(isDisplayed()));
    }

    @Test
    public void contactUsClicked_ShowsContactUsPage() {

        onView(withId(R.id.navigation_contact)).perform(click());

        onView(withText("contact")).check(matches(isDisplayed()));

    }
}
