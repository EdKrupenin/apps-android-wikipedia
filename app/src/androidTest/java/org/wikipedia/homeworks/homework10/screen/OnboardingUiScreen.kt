package org.wikipedia.homeworks.homework10.screen

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName: String
        get() = "org.wikipedia.alpha"

    val viewPager = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "fragment_pager")
    }

    val imageView = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val primaryInfoText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryInfoText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val items = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "languagesList")
    }

    val addLanguageBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName,"addLanguageButton")
    }

    val tabLayout = UiView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }

    val skipBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val getStartedBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }
}