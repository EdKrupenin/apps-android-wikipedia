package org.wikipedia.homeworks.homework20.screen

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.item.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.item.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.item.NewsCardViewItem
import org.wikipedia.homeworks.homework07.item.SearchCardViewItem
import org.wikipedia.homeworks.homework20.items.InTheNewsViewItem
import org.wikipedia.homeworks.homework20.items.TopReadViewItem
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.invokeAtDescendantText
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework22.extention.invokeByClass
import org.wikipedia.homeworks.homework22.extention.invokeByID
import org.wikipedia.views.WikiCardView


object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Explore Screen"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Tool bar title"))
    }

    val items by lazy {
        KRecyclerView(builder = {
            withId(R.id.feed_view)
        }, itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::AnnouncementCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::TopReadViewItem)
            itemType(::NewsCardViewItem)
            itemType(::InTheNewsViewItem)
        }).name(withParent("List of block"))
    }

    fun searchItemByClass(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {
        items.invokeByClass(
            targetIndex = targetIndex,
            targetClass = WikiCardView::class.java,
            blockName = "Search card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun announcementItemByID(targetIndex: Int = 0, function: AnnouncementCardViewItem.() -> Unit) {
        items.invokeByID(
            targetIndex = targetIndex,
            targetID = R.id.view_announcement_text,
            blockName = "Announcement card",
            limiter = (10 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun dayHeaderItemByID(targetIndex: Int, function: DayHeaderCardViewItem.() -> Unit) {
        items.invokeByID(
            targetIndex = targetIndex,
            targetID = R.id.day_header_text,
            blockName = "Day header card",
            limiter = (20 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun topReadItemByClass(targetIndex: Int, function: TopReadViewItem.() -> Unit) {
        items.invokeByClass(
            targetIndex = targetIndex,
            targetClass = TopReadCardView::class.java,
            blockName = "Top read card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun topReadItem(function: TopReadViewItem.() -> Unit) {
        items.invokeAtDescendantText<TopReadViewItem>("Top read", function)
    }

    fun inTheNewsItem(function: InTheNewsViewItem.() -> Unit) {
        items.invokeAtDescendantText<InTheNewsViewItem>("In the news", function)
    }
}