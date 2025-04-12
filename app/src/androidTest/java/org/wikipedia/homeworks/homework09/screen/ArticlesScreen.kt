package org.wikipedia.homeworks.homework09.screen

import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.item.ListCardItemViewItem
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.invokeAtIndex
import org.wikipedia.homeworks.homework20.tools.name

object ArticlesScreen : NamedKScreen<ArticlesScreen>() {
    override val screenName = "Articles Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val appToolbar by lazy {
        KToolbar { withId(R.id.toolbar) }
            .name(withParent("Tool bar"))
    }

    val storyText by lazy {
        KTextView {
            withId(R.id.story_text_view)
        }.name(withParent("Story text"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.news_story_items_recyclerview)
            },
            itemTypeBuilder = {
                itemType(::ListCardItemViewItem)
            }
        ).name(withParent("Story card items"))
    }

    fun cardItemView(index: Int, function: ListCardItemViewItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }
}