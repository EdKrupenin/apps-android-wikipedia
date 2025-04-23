package org.wikipedia.homeworks.homework22.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework09.screen.ArticlesScreen
import org.wikipedia.homeworks.homework09.test.ARTICLES_SCREEN_ITEM
import org.wikipedia.homeworks.homework09.test.EXPLORE_SCREEN_ITEM
import org.wikipedia.homeworks.homework11.screen.ErrorScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework19.checks
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew
import org.wikipedia.main.MainActivity

class Test22 : AllureSupportTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun simpleTest() {
        before {
            device.network.enable()
        }.after { device.network.enable() }.run {
            actions {
                click(OnboardingScreen.skipBtn)
            }
            checks {
                ExploreScreenNew {
                    searchItemByClass {
                        hasAnyText(searchText)
                        hasAnyDrawable(voiceIcon)
                    }
                    announcementItemByID {
                        hasAnyText(announcementText)
                        hasAnyDrawable(headerImage)
                        isDisplayed(positiveButton)
                        isDisplayed(negativeButton)
                    }
                    dayHeaderItemByID(0) {
                        hasAnyText(dayHeaderText)
                    }
                    topReadItemByClass(4) {
                        hasAnyText(headerText)
                        hasAnyDrawable(headerMenu)
                        hasAnyText(footerText)
                    }
                }
            }
            actions {
                ExploreScreenNew.inTheNewsItem {
                    tabNewsItem(EXPLORE_SCREEN_ITEM) {
                        click(this)
                    }
                }
            }
            ArticlesScreen {
                checks {
                    hasAnyText(storyText)
                    isDisplayed(appToolbar)
                }
                actions {
                    cardItemView(ARTICLES_SCREEN_ITEM) {
                        disableNetwork()
                        click(this)
                    }
                }
            }
            ErrorScreen {
                checks {
                    isDisplayed(errorIcon)
                    isDisplayed(errorText)
                    isDisplayed(errorBtn)
                }
                actions {
                    enableNetwork(device)
                    click(errorBtn)
                }
            }
        }
    }
}