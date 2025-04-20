package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen.withParent
import org.wikipedia.homeworks.homework20.tools.name

class SearchCardViewItem(matcher: Matcher<View>) : KRecyclerItem<SearchCardViewItem>(matcher) {
    val searchIcon by lazy {
        KImageView(matcher) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.name(withParent("search Icon"))
    }
    val searchText by lazy {
        KTextView(matcher) {
            withText(R.string.search_hint)
        }.name(withParent("Search text"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Voice Icon"))
    }
}