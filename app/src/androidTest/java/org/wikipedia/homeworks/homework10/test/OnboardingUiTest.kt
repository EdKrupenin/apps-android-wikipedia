package org.wikipedia.homeworks.homework10.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework10.screen.OnboardingUiScreen
import org.wikipedia.main.MainActivity


class OnboardingUiTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textFirstScreenElementsPresence() = run {
        step("First screen elements presence") {
            OnboardingUiScreen.imageView.isDisplayed()
            OnboardingUiScreen.primaryInfoText.isDisplayed()
            OnboardingUiScreen.secondaryInfoText.isDisplayed()
            OnboardingUiScreen.items.isDisplayed()
            OnboardingUiScreen.addLanguageBtn.isDisplayed()
            OnboardingUiScreen.skipBtn.isDisplayed()
            OnboardingUiScreen.tabLayout.isDisplayed()
            OnboardingUiScreen.continueBtn.isDisplayed()
        }
    }

    @Test
    fun testCheckingTextOnFirstScreenTab() = run {
        step("Checking text on first screen tab") {
            OnboardingUiScreen {
                step("Checking primary Info Text") {
                    primaryInfoText.hasAnyText()
                }
                step("Checking secondary Info Text") {
                    secondaryInfoText.hasText("We’ve found the following on your device:")
                }
                step("Checking items") {
                    items.isDisplayed()
                }
            }
        }
    }

    @Test
    fun testCheckingTextOnSecondScreenTab() = run {
        step("Checking text on first screen tab") {
            OnboardingUiScreen {
                step("Next button click") {
                    continueBtn.click()
                }
                step("Checking text on second screen tab") {
                    primaryInfoText.hasAnyText()
                }
            }
        }
    }

    @Test
    fun testCheckingTextOnThirdScreenTab() = run {
        step("Checking text on first screen tab") {
            OnboardingUiScreen {
                step("Next button click") {
                    continueBtn.click()
                }
                step("Next button click") {
                    continueBtn.click()
                }
                step("Checking text on third screen tab") {
                    primaryInfoText.hasText("New ways to explore")
                }
            }
        }
    }

    @Test
    fun testContinueButtonDoubleClickToLastPage() = run {
        OnboardingUiScreen {
            step("Continue Button Click go to Second Tab") {
                continueBtn.click()
            }
            step("Continue Button Click go to Third tab") {
                continueBtn.click()
            }
            step("Continue Button Click go to Fourth tab") {
                continueBtn.click()
            }
            step("Checking fourth screen tab") {
                items.isNotDisplayed()
                getStartedBtn.isDisplayed()
            }
        }
    }
}