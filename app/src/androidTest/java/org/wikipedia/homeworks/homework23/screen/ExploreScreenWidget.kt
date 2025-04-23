package org.wikipedia.homeworks.homework23.screen

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework22.extention.invokeByClass
import org.wikipedia.homeworks.homework23.widget.SearchWidget


object ExploreScreenWidget : NamedKScreen<ExploreScreenWidget>() {
    override val layoutId = null
    override val screenName = "ExploreScreen"
    override val viewClass = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Search widget"))
    }

    val items by lazy {
        KRecyclerView(builder = {
            withId(R.id.feed_view)
        }, itemTypeBuilder = {
            itemType(::TopReadViewItemNew)
        }).name(withParent("List of block"))
    }

    fun topReadItemByClass(targetIndex: Int, function: TopReadViewItemNew.() -> Unit) {
        items.invokeByClass(
            targetIndex = targetIndex,
            targetClass = TopReadCardView::class.java,
            blockName = "Top read card",
            limiter = (4 * targetIndex).coerceAtLeast(10),
            function = function
        )
    }
}