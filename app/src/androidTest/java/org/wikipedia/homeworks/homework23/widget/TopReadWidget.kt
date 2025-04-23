package org.wikipedia.homeworks.homework23.widget

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.ListCardItemView
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent
import org.wikipedia.homeworks.homework22.extention.invokeByClass
import org.wikipedia.homeworks.homework23.tools.KWidget

class TopReadWidget : KWidget<TopReadWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val headerText by lazy {
        KTextView(parent) { withId(R.id.view_card_header_title) }
            .name(withParent("Header"))
    }
    val headerMenu by lazy {
        KImageView(parent) { withId(R.id.view_list_card_header_menu) }
            .name(withParent("Header menu"))
    }

    private val topCardItems by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list_container)
            },
            itemTypeBuilder = {
                itemType(::ListCardItemViewItem)
            }
        ).name(withParent("Top Read Card Items"))
    }

    val footerText by lazy {
        KTextView(parent) { withId(R.id.footerActionButton) }
            .name(withParent("Footer text"))
    }

    fun cardViewItemByClass(targetIndex: Int = 0, function: ListCardItemViewItem.() -> Unit) {
        topCardItems.invokeByClass(
            targetIndex = targetIndex,
            targetClass = ListCardItemView::class.java,
            blockName = "Card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }
}