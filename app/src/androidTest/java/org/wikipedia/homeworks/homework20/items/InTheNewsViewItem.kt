package org.wikipedia.homeworks.homework20.items

import android.view.View
import androidx.room.Index
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.items.subitems.TabNewsItemView
import org.wikipedia.homeworks.homework20.tools.invokeAtIndex
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent

class InTheNewsViewItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsViewItem>(matcher) {
    val header by lazy {
        KTextView(matcher) { withId(R.id.view_card_header_title) }
            .name(withParent("Header"))
    }

    val menu by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
            .name(withParent("Menu"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },
            itemTypeBuilder = {
                itemType(::TabNewsItemView)
            }
        ).name(withParent("Tab News list"))
    }

    fun tabNewsItem(index: Int, function: TabNewsItemView.() -> Unit) {
        items.invokeAtIndex(index, function)
    }
}