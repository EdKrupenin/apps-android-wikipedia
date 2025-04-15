package org.wikipedia.homeworks.homework20.items.subitems

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew.withParent
//import org.wikipedia.homeworks.homework20.tools.withParent

class TabNewsItemView(matcher: Matcher<View>) : KRecyclerItem<TabNewsItemView>(matcher) {
    val image by lazy {
        KImageView(matcher) { withId(R.id.horizontal_scroll_list_item_image) }
            .name(withParent("Image"))
    }
    val text by lazy {
        KTextView(matcher) { withId(R.id.horizontal_scroll_list_item_text) }
            .name(withParent("Text"))
    }
}