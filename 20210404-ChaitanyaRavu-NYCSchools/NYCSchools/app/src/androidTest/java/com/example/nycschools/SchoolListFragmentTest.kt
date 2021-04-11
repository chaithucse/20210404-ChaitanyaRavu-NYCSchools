package com.example.nycschools

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nycschools.view.SchoolListFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify

/**
 * Test School List and Detail Fragment using Espresso with Navigation component testing framework
 */
@RunWith(AndroidJUnit4::class)
class SchoolListFragmentTest {

    @Test
    fun testNavigationToSchoolDetailScreen() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
                ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.nav_graph)

        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<SchoolListFragment>()

        // Set the NavController property on the fragment
        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // Verify that performing a click changes the NavController’s state
        onView(ViewMatchers.withId(R.id.school_title)).perform(ViewActions.click())
        verify(navController).navigate(R.id.schoolListFragment)

        //Check SAT scores views are displayed in School detailed fragment
        onView(withId(R.id.sat_total)).check((matches(isDisplayed())))
        onView(withId(R.id.reading_avg)).check((matches(isDisplayed())))
        onView(withId(R.id.math_avg)).check((matches(isDisplayed())))
        onView(withId(R.id.writing_avg)).check((matches(isDisplayed())))
    }
}