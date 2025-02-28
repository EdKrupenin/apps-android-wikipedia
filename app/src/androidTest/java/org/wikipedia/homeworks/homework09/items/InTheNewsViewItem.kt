package org.wikipedia.homeworks.homework09.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework09.items.subitems.TabNewsItemView

class InTheNewsViewItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsViewItem>(matcher) {
    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val items = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::TabNewsItemView)
        }
    )
}