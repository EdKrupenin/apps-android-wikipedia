package org.wikipedia.homeworks.homework28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.R
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew
import org.wikipedia.homeworks.homework29.Credentials
import org.wikipedia.homeworks.homework29.Users
import org.wikipedia.main.MainActivity

class TestWithScenario : AllureSupportTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val rule = CustomDeprecatedTestRule(testLogger)

    @Deprecated("Do not run")
    @Test
    fun deprecatedTest() = run {

    }
    @Test
    fun deprecatedTest2() = run {

    }
    @Test
    fun deprecatedTest3() = run {

    }

    @Test
    fun test() = run {
        BuildConfig.HOME_WORK_NUMBER
        val login = Users.alfaLogin
        val password = Credentials.getPassword(login)
        actions {
            authorize(Users.EduardoKru)
            ExploreScreenNew.featuredArticleItemByID(0) {
                click(this.articleTitle)
            }
            click(R.string.nav_item_saved)
            sleep(1000L)
            pressBack()
            ExploreScreenNew.inTheNewsItem {
                tabNewsItem(1) {
                    click(this)
                    pressBack()
                }
            }
            repeat(4) {
                swipeUp()
            }
            ExploreScreenNew.featuredArticleItemByID(1) {
                click(this.articleTitle)
            }
            click(R.string.nav_item_saved)
            sleep(1000L)
            pressBack()
            val savedBnt = device.uiDevice.findObject(UiSelector().textContains("Saved"))
            click(savedBnt)
        }
    }
}