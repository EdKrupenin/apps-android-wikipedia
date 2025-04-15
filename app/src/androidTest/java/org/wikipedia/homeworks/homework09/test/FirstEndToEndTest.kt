package org.wikipedia.homeworks.homework09.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem
import org.wikipedia.homeworks.homework07.screen.ExploreScreen
import org.wikipedia.homeworks.homework09.items.InTheNewsViewItem
import org.wikipedia.homeworks.homework09.items.subitems.TabNewsItemView
import org.wikipedia.homeworks.homework09.screen.ArticlesScreen
import org.wikipedia.homeworks.homework09.screen.WebViewScreen
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework20.tools.customPerform
import org.wikipedia.homeworks.homework21.tools.CustomViewAssertion
import org.wikipedia.homeworks.homework21.tools.CustomViewAction
import org.wikipedia.homeworks.homework21.extentions.customCheck
import org.wikipedia.main.MainActivity

const val EXPLORE_SCREEN_ITEM = 3
const val ARTICLES_SCREEN_ITEM = 1

class FirstEndToEndTest : AllureSupportTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() = run {
        step("Click skip button on onboarding screen") {
            OnboardingScreen.skipBtn.customCheck(CustomViewAssertion("Skip"))
            OnboardingScreen.skipBtn.customPerform(CustomViewAction())
        }
        step("Find In The News block and click to $EXPLORE_SCREEN_ITEM item") {
            ExploreScreen.items.childWith<InTheNewsViewItem> {
                withDescendant {
                    withText("In the news")
                }
            }.perform {
                step("Swipe to $EXPLORE_SCREEN_ITEM item") {
                    items.childAt<TabNewsItemView>(EXPLORE_SCREEN_ITEM) {
                        step("Click to item") {
                            click()
                        }
                    }
                }
            }
        }
        step("Find and click to $ARTICLES_SCREEN_ITEM article") {
            ArticlesScreen.items.childAt<ListCardItemViewItem>(ARTICLES_SCREEN_ITEM) {
                step("Click to $ARTICLES_SCREEN_ITEM item") {
                    click()
                }
            }
        }
        step("Check page view was open") {
            /*
             * KView doesn't have an `isEnabled()` matcher, which Kaspresso tries to use internally with `isDisplayed()`.
             * To avoid this issue, use `isCompletelyDisplayed()`, `isVisible()` or `isNotGone()`
             */
            WebViewScreen.webView.isCompletelyDisplayed()
        }
    }
}