package org.wikipedia.homeworks.homework08.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.items.OnboardingPageItem

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val viewPager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPageItem)
        }
    )

    val skipBtn = KButton{
        withId(R.id.fragment_onboarding_skip_button)
    }

    val tabLayout = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }

    val continueBtn = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val getStartedBtn = KButton {
        withId(R.id.fragment_onboarding_done_button)
    }
}