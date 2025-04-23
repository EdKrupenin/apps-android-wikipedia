package org.wikipedia.homeworks.homework23.widget

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent
import org.wikipedia.homeworks.homework23.tools.KWidget

class SearchWidget : KWidget<SearchWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val searchIcon by lazy {
        KImageView(parent) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.name(withParent("search Icon"))
    }
    val searchText by lazy {
        KTextView(parent) {
            withText(R.string.search_hint)
        }.name(withParent("Search text"))
    }

    val voiceIcon by lazy {
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.name(withParent("Voice Icon"))
    }
}