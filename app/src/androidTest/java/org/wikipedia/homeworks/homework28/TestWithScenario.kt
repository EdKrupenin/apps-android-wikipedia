package org.wikipedia.homeworks.homework28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework19.checks
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew
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
        actions {
            click(OnboardingScreen.skipBtn)
            ExploreScreenNew.featuredArticleItemByID(0) {
                click(this.articleTitle)
            }
            val saveBnt = device.uiDevice.findObject(UiSelector().textContains("Save"))
            click(saveBnt)
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
            click(saveBnt)
            sleep(1000L)
            pressBack()
            val savedBnt = device.uiDevice.findObject(UiSelector().textContains("Saved"))
            click(savedBnt)
        }
    }
}