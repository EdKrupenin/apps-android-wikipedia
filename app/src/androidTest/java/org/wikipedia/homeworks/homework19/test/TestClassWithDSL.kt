package org.wikipedia.homeworks.homework19.test

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem
import org.wikipedia.homeworks.homework07.screen.ExploreScreen
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework09.items.InTheNewsViewItem
import org.wikipedia.homeworks.homework09.items.subitems.TabNewsItemView
import org.wikipedia.homeworks.homework09.screen.ArticlesScreen
import org.wikipedia.homeworks.homework09.screen.WebViewScreen
import org.wikipedia.homeworks.homework09.test.ARTICLES_SCREEN_ITEM
import org.wikipedia.homeworks.homework09.test.EXPLORE_SCREEN_ITEM
import org.wikipedia.homeworks.homework11.screen.ErrorScreen
import org.wikipedia.homeworks.homework19.actions
import org.wikipedia.homeworks.homework19.checks

import org.wikipedia.main.MainActivity

class TestClassWithDSL : AllureSupportTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() = run {

        actions {
            click(OnboardingScreen.skipBtn, "btn Skip")
            step("Find In The News block and click to $EXPLORE_SCREEN_ITEM item") {
                ExploreScreen.items.childWith<InTheNewsViewItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    step("Swipe to $EXPLORE_SCREEN_ITEM item") {
                        items.childAt<TabNewsItemView>(EXPLORE_SCREEN_ITEM) {
                            click(this, "to $EXPLORE_SCREEN_ITEM item of TabNews")
                        }
                    }
                }
            }
            step("Find $ARTICLES_SCREEN_ITEM article") {
                ArticlesScreen.items.childAt<ListCardItemViewItem>(ARTICLES_SCREEN_ITEM) {
                    click(this, "to $ARTICLES_SCREEN_ITEM item of article")
                }
            }
            step("Scroll to reference Id element") {
                flakySafely(150000) {
                    WebViewScreen.realWebView {
                        withElement(Locator.XPATH, "//*[@id='References']") {
                            scroll(this, "to References")
                        }
                    }
                }
            }
        }
        WebViewScreen.realWebView {
            withElement(Locator.XPATH, "//*[@id='References']") {
                checks.hasText(this, "References", "Check References text")
            }
        }

        step("Check References text") {
            WebViewScreen.realWebView {
                withElement(Locator.XPATH, "//*[@id='References']") {
                    checks.hasText(this, "References", "Check References text")
                    actions.click(this, "Click to References")
                }
            }
        }
        step("Click to [5] References text") {
            flakySafely(150000) {
                WebViewScreen.realWebView {
                    withElement(Locator.XPATH, "//*[@id='back_link_cite_note-dbm-9']") {
                        actions.scroll(this, "to References")
                        checks.hasText(this, "[5]", "Check references text")
                        actions.click(this, "to References")
                    }
                    withElement(Locator.XPATH, "//*[@id='cite_ref-dbm_9-0']/a") {
                        actions.click(this, "to References")
                    }
                }
            }
        }
    }

    @Test
    fun orientationTest() = run {
        actions {
            click(OnboardingScreen.skipBtn, "btn Skip")
            setOrientationLeft(device)
            sleep(5000)
        }
        checks.isNotOrientationNatural(device)
        actions {
            setOrientationNatural(device)
            sleep(5000)
        }
        checks.isOrientationNatural(device)
    }

    @Test
    fun testNetworkErrorHandling() {
        before {
            device.network.enable()
        }.after { device.network.enable() }.run {
            actions {
                click(OnboardingScreen.skipBtn, "btn Skip")
                step("Find In The News block and click to $EXPLORE_SCREEN_ITEM item") {
                    ExploreScreen.items.childWith<InTheNewsViewItem> {
                        withDescendant {
                            withText("In the news")
                        }
                    }.perform {
                        step("Swipe to $EXPLORE_SCREEN_ITEM item") {
                            items.childAt<TabNewsItemView>(EXPLORE_SCREEN_ITEM) {
                                click(this, "to $EXPLORE_SCREEN_ITEM item of TabNews")
                            }
                        }
                    }
                }
                step("Find $ARTICLES_SCREEN_ITEM article") {
                    ArticlesScreen.items.childAt<ListCardItemViewItem>(ARTICLES_SCREEN_ITEM) {
                        disableNetwork(device)
                        click(this, "to $ARTICLES_SCREEN_ITEM item of article")
                    }
                }

            }

            ErrorScreen {
                checks {
                    isDisplayed(errorIcon, "Check error icon")
                    isDisplayed(errorText, "Check error text")
                    isDisplayed(errorBtn, "Check error btn")
                }
            }

            actions {
                enableNetwork(device)
                click(ErrorScreen.errorBtn, "to Retry button")
            }

            checks {
                isCompletelyDisplayed(WebViewScreen.webView, "Check page view")
            }

        }
    }
}