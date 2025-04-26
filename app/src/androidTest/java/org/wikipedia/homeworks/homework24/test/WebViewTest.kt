package org.wikipedia.homeworks.homework24.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework09.screen.ArticlesScreen
import org.wikipedia.homeworks.homework09.test.ARTICLES_SCREEN_ITEM
import org.wikipedia.homeworks.homework09.test.EXPLORE_SCREEN_ITEM
import org.wikipedia.main.MainActivity
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework19.checks
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew
import org.wikipedia.homeworks.homework24.screen.WebViewDSLScreen

const val REFERENCE_INDEX = 2
const val REFERENCE_TITLE = "References"
const val REFERENCE_INDEX_TEXT = "[${REFERENCE_INDEX}]"

class WebViewTest : AllureSupportTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() = run {
        actions {
            click(OnboardingScreen.skipBtn)
            ExploreScreenNew.inTheNewsItem {
                tabNewsItem(EXPLORE_SCREEN_ITEM) {
                    click(this)
                }
            }
            ArticlesScreen {
                cardItemView(ARTICLES_SCREEN_ITEM) {
                    click(this)
                }
            }
        }
        WebViewDSLScreen {
            actions {
                referenceTitle {
                    click(this)
                }
            }
            checks {
                hasText(referenceTitle, REFERENCE_TITLE)
                referenceItem(REFERENCE_INDEX) {
                    containsText(this, REFERENCE_INDEX_TEXT)
                }
            }

        }
    }
}