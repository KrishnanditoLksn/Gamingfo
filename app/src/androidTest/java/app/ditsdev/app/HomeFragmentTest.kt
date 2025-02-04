package app.ditsdev.app

import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.ditsdev.gamingfo.ui.home.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    @Test
    fun testHomeIsOkay() {
        launchFragment {
            HomeFragment()
        }
    }
}