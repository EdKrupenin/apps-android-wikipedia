package org.wikipedia.homeworks.homework20.tools

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    index: Int,
    function: T.() -> Unit
) {
    val recycler = this
    childAt<T>(index) {
        name(recycler.name().withParent("$index"))
        function()
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtDescendantText(
    descendantText: String,
    function: T.() -> Unit
) {
    val recycler = this
    val item = childWith<T>(
        childMatcher = {
            withDescendant {
                withText(descendantText)
            }
        }
    )
    item.name(recycler.name().withParent(descendantText))
    item.function()
}


inline fun <reified T : KRecyclerItem<*>> KRecyclerView.getAtDescendantText(
    descendantText: String
) = childWith<T> {
    withDescendant {
        withText(descendantText)
    }
}.name(this.name().withParent(descendantText))
