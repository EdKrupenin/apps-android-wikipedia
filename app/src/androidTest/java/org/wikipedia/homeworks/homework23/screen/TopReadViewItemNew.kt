package org.wikipedia.homeworks.homework23.screen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.homeworks.homework20.items.TopReadViewItem
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework23.screen.ExploreScreenWidget.withParent
import org.wikipedia.homeworks.homework23.widget.TopReadWidget

class TopReadViewItemNew(matcher: Matcher<View>) : KRecyclerItem<TopReadViewItem>(matcher) {
    val topReadWidget by lazy {
        TopReadWidget(matcher) {
            withClassName(equalTo(TopReadCardView::class.java.name))
        }.name(withParent("Top Read widget"))
    }
}