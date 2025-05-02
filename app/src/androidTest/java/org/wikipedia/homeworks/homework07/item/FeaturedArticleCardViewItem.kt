package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent

class FeaturedArticleCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<DayHeaderCardViewItem>(matcher) {
    val headerText by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("day Header Text"))
    }
    val headerMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("day Header Text"))
    }
    val articleTitle by lazy {
        KImageView(matcher) {
            withId(R.id.articleTitle)
        }.name(withParent("article Title"))
    }

}