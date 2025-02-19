package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ListCardItemViewItem(matcher: Matcher<View>) : KRecyclerItem<ListCardItemViewItem>(matcher) {
    val circleNumber = KView(matcher){
        withId(R.id.view_list_card_number)
    }

    val cardTitle = KTextView(matcher){
        withId(R.id.view_list_card_item_title)
    }

    val cardSubtitle = KTextView(matcher){
        withId(R.id.view_list_card_item_subtitle)
    }

    val cardGraph = KView(matcher){
        withId(R.id.view_list_card_item_graph)
    }

    val cardPageViews = KTextView(matcher){
        withId(R.id.view_list_card_item_pageviews)
    }

    val cardImage = KImageView(matcher){
        withId(R.id.view_list_card_item_image)
    }
}