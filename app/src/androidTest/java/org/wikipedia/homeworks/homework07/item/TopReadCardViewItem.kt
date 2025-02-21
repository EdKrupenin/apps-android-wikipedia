package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewItem>(matcher) {
    val headerText = KTextView(matcher){
        withId(R.id.view_card_header_title)
        withText(R.string.view_top_read_card_title)
    }
    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val topCardItems = KRecyclerView(
        builder = {
            withId(R.id.view_list_card_list_container)
        },
        itemTypeBuilder = {
            itemType(::ListCardItemViewItem)
        }
    )

    val footerText = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }
}