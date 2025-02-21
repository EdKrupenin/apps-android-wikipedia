package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsCardViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardViewItem>(matcher) {
    val headerText = KTextView(matcher){
        withId(R.id.view_card_header_title)
        withText(R.string.view_card_news_title)
    }
    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val newsCardItems = KRecyclerView(
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::NewsItemViewItem)
        }
    )
}