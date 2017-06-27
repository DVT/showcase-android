package za.co.dvt.android.showcase.ui


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import za.co.dvt.android.showcase.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

@RunWith(AndroidJUnit4::class)
class MainNavigationActivityTest {

    @Rule
    @JvmField
    public var mainActivityActivityTestRule = ActivityTestRule(MainNavigationActivity::class.java)


    @Test
    fun aboutClicked_ShowsAboutPage() {

        onView(withId(R.id.navigation_about)).perform(click())


    }

    @Test
    fun contactUsClicked_ShowsContactUsPage() {

        onView(withId(R.id.navigation_contact)).perform(click())



    }
}
