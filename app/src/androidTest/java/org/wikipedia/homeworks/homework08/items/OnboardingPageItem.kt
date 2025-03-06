package org.wikipedia.homeworks.homework08.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPageItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingPageItem>(matcher) {
    val imageView = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val primaryInfoText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val secondaryInfoText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val items = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languagesList)
            isDescendantOfA { withId(R.id.fragment_pager) }
        },
        itemTypeBuilder = {
            itemType(::LabelItem)
        }
    )

    val addLanguageBtn = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}