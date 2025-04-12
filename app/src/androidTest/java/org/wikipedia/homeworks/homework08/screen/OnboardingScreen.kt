package org.wikipedia.homeworks.homework08.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.items.OnboardingPageItem
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.name

object OnboardingScreen : NamedKScreen<OnboardingScreen>() {
    override val screenName = "Onboarding screen"
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

    val skipBtn by lazy {
        KButton { withId(R.id.fragment_onboarding_skip_button) }
            .name(withParent("Skip button"))
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