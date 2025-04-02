package org.wikipedia.homeworks.homework13.test

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
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
import org.wikipedia.homeworks.homework13.items.ReferencePageItem
import org.wikipedia.homeworks.homework13.screens.BottomSheetScreen
import org.wikipedia.homeworks.homework13.screens.LinkPreviewOverlayScreen
import org.wikipedia.main.MainActivity

class WebViewTest : AllureSupportTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() = run {
        step("Skip onboarding screen") {
            OnboardingScreen.skipBtn.click()
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
        step("Scroll to reference Id element") {
            flakySafely(150000) {
                WebViewScreen.realWebView {
                    withElement(Locator.XPATH, "//*[@id='References']") {
                        scroll()
                    }
                }
            }
        }
        step("Check References text") {
            WebViewScreen.realWebView {
                withElement(Locator.XPATH, "//*[@id='References']") {
                    hasText("References")
                }
            }
        }
        step("Check References text") {
            WebViewScreen.realWebView {
                withElement(Locator.XPATH, "//*[@id='References']") {
                    step("Check text") { hasText("References") }
                    step("Click to References text") { click() }
                }
            }
        }
        step("Click to [5] References text") {
            flakySafely(150000) {
                WebViewScreen.realWebView {
                    withElement(Locator.XPATH, "//*[@id='back_link_cite_note-dbm-9']") {
                        step("Check text") { scroll() }
                        step("Check text") { hasText("[5]") }
                        step("Click to References") { click() }
                    }
                    withElement(Locator.XPATH, "//*[@id='cite_ref-dbm_9-0']/a") {
                        step("Click to References") { click() }
                    }
                }
            }
        }
        step("Check bottom sheet") {
            BottomSheetScreen {
                flakySafely(timeoutMs = 15000) {
                    step("Check title") {
                        title.containsText("Reference")
                    }
                    step("Check ID = 5") {
                        repeat(10) {
                            try {
                                referencePager.childAt<ReferencePageItem>(3) {
                                    id.hasText("5.")
                                }
                                return@step
                            } catch (e: AssertionError) {
                                referencePager.swipeLeft()
                            }
                        }
                        throw AssertionError("Page with ID = 5 not found in ViewPager2")
                    }
                    step("Check ID = 5 second variant") {
                        idText {
                            hasText("5.")
                        }
                    }
                }
            }
        }
        step("Close bottom sheet") {
            repeat(4) {
                device.uiDevice.pressBack()
            }
        }
        step("Search second reference with class 'mw-redirect' and click it") {
            WebViewScreen.realWebView {
                step("Search reference") {
                    withElement(Locator.XPATH, "(//a[contains(@class, 'mw-redirect')])[2]") {
                        step("Scroll to reference") { scroll() }
                        step("Click to References") { click() }
                    }
                }
            }
        }
        step("Click Read article button") {
            LinkPreviewOverlayScreen {
                step("Check button visible") {
                    readArticle.isDisplayed()
                }
                step("Click button") {
                    readArticle.click()
                    readArticle.click()
                }
            }
        }
        step("Scroll to reference Id element again") {
            WebViewScreen.realWebView {
                withElement(Locator.XPATH, "//*[@id='References']") {
                    scroll()
                }
            }
        }
    }
}