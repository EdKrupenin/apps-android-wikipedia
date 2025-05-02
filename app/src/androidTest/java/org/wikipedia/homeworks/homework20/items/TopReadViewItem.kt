package org.wikipedia.homeworks.homework20.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem
import org.wikipedia.homeworks.homework20.screen.ExploreScreenNew.withParent
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework22.extention.invokeByID

class TopReadViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadViewItem>(matcher) {
    val headerText by lazy {
        KTextView(matcher) { withId(R.id.view_card_header_title) }
            .name(withParent("Header"))
    }
    val headerMenu by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
            .name(withParent("Header menu"))
    }

    val topCardItems by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list_container)
            },
            itemTypeBuilder = {
                itemType(::ListCardItemViewItem)
            }
        ).name(withParent("Top Card Items"))
    }

    val footerText by lazy {
        KTextView(matcher) { withId(R.id.footerActionButton) }
            .name(withParent("Footer text"))
    }
}