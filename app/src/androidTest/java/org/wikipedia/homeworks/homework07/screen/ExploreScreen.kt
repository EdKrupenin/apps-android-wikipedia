package org.wikipedia.homeworks.homework07.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.item.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.item.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.item.NewsCardViewItem
import org.wikipedia.homeworks.homework07.item.SearchCardViewItem
import org.wikipedia.homeworks.homework07.item.TopReadCardViewItem
import org.wikipedia.homeworks.homework09.items.InTheNewsViewItem

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::AnnouncementCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::TopReadCardViewItem)
            itemType(::NewsCardViewItem)
            itemType(::InTheNewsViewItem)
        }
    )
}