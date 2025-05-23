package org.wikipedia.homeworks.homework27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew
import org.wikipedia.homeworks.homework28.CustomAllureTestRule
import org.wikipedia.homeworks.homework28.HappyTestRule
import org.wikipedia.main.MainActivity

class TestWithCustomReport : AllureSupportTest() {
    @get:Rule(order = 0)
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule(order = 1)
    val testRule = HappyTestRule(testLogger)

    @get:Rule(order = 2)
    val allureRule = CustomAllureTestRule(testLogger)

    @Test
    @AllureId("12345")
    fun positiveTest() = run {
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

    @Test
    fun negativeTest() = run {
        actions {
            click(OnboardingScreen.skipBtn)
            ExploreScreenNew.featuredArticleItemByID(0) {
                click(this.articleTitle)
            }
            val saveBnt = device.uiDevice.findObject(UiSelector().textContains("Save"))
            click(saveBnt)
            sleep(1000L)
            pressBack()
            ExploreScreenNew.topReadItemByClass(3) {
                click(this)
            }
        }
    }
}