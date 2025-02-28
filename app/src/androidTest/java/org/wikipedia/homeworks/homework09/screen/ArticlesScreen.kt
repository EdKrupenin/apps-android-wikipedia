package org.wikipedia.homeworks.homework09.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem

object ArticlesScreen : KScreen<ArticlesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val appToolbar = KToolbar{
        withId(R.id.toolbar)
    }

    val storyText = KTextView{
        withId(R.id.story_text_view)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::ListCardItemViewItem)
        }
    )
}