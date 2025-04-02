package org.wikipedia.homeworks.homework08.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.items.OnboardingPageItem
import org.wikipedia.homeworks.homework08.matcher.hasSelectedTabAt
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.main.MainActivity

class OnboardingScreenTest : AllureSupportTest() {

    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textFirstScreenElementsPresence(){
        run {
            step("First screen elements presence") {
                OnboardingScreen.viewPager.childAt<OnboardingPageItem>(0){
                    imageView.isVisible()
                    primaryInfoText.isVisible()
                    secondaryInfoText.isVisible()
                    items.isVisible()
                    addLanguageBtn.isVisible()
                }

                OnboardingScreen.skipBtn.isVisible()
                OnboardingScreen.tabLayout.isVisible()
                OnboardingScreen.continueBtn.isVisible()
            }
        }
    }

    @Test
    fun testCheckingTextOnFirstScreenTab() = run {
        step("Checking text on first screen tab") {
            OnboardingScreen.viewPager.childAt<OnboardingPageItem>(0){
                primaryInfoText.hasText(R.string.onboarding_welcome_title_v2)
                secondaryInfoText.hasText(R.string.onboarding_multilingual_secondary_text)
                items {
                    isVisible()
                }
            }

        }
    }

    @Test
    fun testContinueButtonClickSwipesToNextPage() = run {
        step("Continue Button Click go to Second tab") {
            OnboardingScreen {
                continueBtn.click()
            }
        }
        step("Checking second screen tab"){
            OnboardingScreen {
                viewPager.childAt<OnboardingPageItem>(1) {
                    primaryInfoText.hasText(R.string.onboarding_explore_title)
                    items.isGone()
                }
                tabLayout.matches { hasSelectedTabAt(1) }
            }
        }

    }

    @Test
    fun testContinueButtonDoubleClickToLastPage() = run {
        step("Continue Button Click go to Second Tab") {
            OnboardingScreen {
                continueBtn.click()
            }
        }
        step("Continue Button Click go to Third tab") {
            OnboardingScreen {
                continueBtn.click()
            }
        }
        step("Continue Button Click go to Fourth tab") {
            OnboardingScreen {
                continueBtn.click()
            }
        }
        step("Checking fourth screen tab"){
            OnboardingScreen {
                viewPager.childAt<OnboardingPageItem>(3) {
                    items.isGone()
                }
                getStartedBtn.isVisible()
            }
        }
    }

}