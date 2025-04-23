package org.wikipedia.homeworks.homework23.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework19.checks
import org.wikipedia.homeworks.homework23.screen.ExploreScreenWidget
import org.wikipedia.main.MainActivity

class TestWidget : AllureSupportTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun widgetTest() = run {
        actions {
            click(OnboardingScreen.skipBtn)
        }
        checks {
            ExploreScreenWidget {
                searchWidget {
                    isDisplayed(searchText)
                }
                topReadItemByClass(0) {
                    topReadWidget {
                        hasAnyText(headerText)
                        //hasAnyDrawable(headerMenu)
                        hasAnyText(footerText)
                    }
                }
            }
        }
        actions {
            ExploreScreenWidget.topReadItemByClass(0) {
                topReadWidget.cardViewItemByClass(3) {
                    click(this)
                }
            }
        }
    }
}