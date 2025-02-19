package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItemViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsItemViewItem>(matcher) {
    val newsImage = KImageView(matcher){
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val newsText = KTextView(matcher){
        withId(R.id.horizontal_scroll_list_item_text)
    }
}