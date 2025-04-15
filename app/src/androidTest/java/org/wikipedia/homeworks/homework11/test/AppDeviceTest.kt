package org.wikipedia.homeworks.homework11.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.After
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
import org.wikipedia.homeworks.homework21.extentions.hasAnyDrawable
import org.wikipedia.main.MainActivity
import java.util.Locale

class AppDeviceTest : AllureSupportTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @After
    fun tearDown() {
        device.uiDevice.setOrientationNatural()
        device.network.enable()
        device.language.switchInApp(Locale.getDefault())
        device.uiDevice.wakeUp()
    }

    @Test
    fun orientationTest() = run {
        step("Onboarding skip button click") {
            OnboardingScreen.skipBtn.click()
        }
        step("Rotate screen and check orientation") {
            step("Rotate screen to left") {
                device.uiDevice.setOrientationLeft()
                Thread.sleep(5000)
            }
            step("Check orientation isn't Natural") {
                assert(!device.uiDevice.isNaturalOrientation())
            }

            step("Rotate screen to Natural") {
                device.uiDevice.setOrientationNatural()
                Thread.sleep(5000)
            }
            step("Check orientation is Natural") {
                assert(device.uiDevice.isNaturalOrientation())
            }
        }
    }

    @Test
    fun testScreenOffOn() = run {
        step("Onboarding skip button click") {
            OnboardingScreen.skipBtn.click()
        }
        step("Turn screen off and on") {
            device.uiDevice.sleep()
            Thread.sleep(5000)
            device.uiDevice.wakeUp()
            Thread.sleep(5000)
        }
        step("Check screen is on") {
            assert(device.uiDevice.isScreenOn())
        }
        step("Check Toolbar is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
            ExploreScreen.toolbarTitle.hasAnyDrawable()
        }
    }

    @Test
    fun testAppMinimizeRestore() = run {
        step("Onboarding skip button click") {
            OnboardingScreen.skipBtn.click()
        }
        step("Minimize and restore app") {
            step("Press home button") { device.uiDevice.pressHome() }
            step("Double tap on RecentApps button") {
                device.uiDevice.pressRecentApps()
                device.uiDevice.pressRecentApps()
            }
            ExploreScreen.toolbarTitle.isDisplayed()
        }
        step("Check Toolbar is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }
    }

    @Test
    fun testNetworkErrorHandling() {
        before {
            device.network.enable()
        }.after { device.network.enable() }.run {
            step("Onboarding skip button click") {
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
                        step("Disable network") { device.network.disable() }
                        click()
                    }
                }
            }

            step("Check error icon text and Retry button") {
                ErrorScreen {
                    errorIcon.isDisplayed()
                    errorText.isDisplayed()
                    errorBtn.isDisplayed()
                }
            }

            step("Enable network") { device.network.enable() }

            step("Click to Retry button") {
                ErrorScreen.errorBtn.click()
            }

            step("Check page view was open") {
                WebViewScreen.webView.isCompletelyDisplayed()
            }
        }
    }

    @Test
    fun testLanguageChange() {
        before { }.after { device.language.switchInApp(Locale.getDefault()) }.run {
            step("Change app language") {
                step("Change app language to Germany") {
                    device.language.switchInApp(Locale.GERMANY)
                }
                step("Check Continue btn text is Fortfahren") {
                    OnboardingScreen.continueBtn.hasText("Fortfahren")
                }
            }
        }
    }

    @Test
    fun testCurrentActivity() = run {
        step("Onboarding skip button click") {
            OnboardingScreen.skipBtn.click()
        }

        step("Check current activity") {
            device.activities.isCurrent(MainActivity::class.java)
        }
    }

//    @Test
//    fun testScreenshot() = run {
//        step("Onboarding skip button click") {
//            OnboardingScreen.skipBtn.click()
//        }
//
//        step("Take and pull screenshot") {
//            val screenshotName = "homework11_screenshot"
//            device.screenshots.take(screenshotName)
//            val buildDirPath = System.getProperty("user.dir")?.plus("/build")
//            val command = "adb pull /sdcard/$screenshotName.png $buildDirPath"
//            println("Running adb command: $command")
//            adbServer.performAdb(command, emptyList())
//        }
//    }

}