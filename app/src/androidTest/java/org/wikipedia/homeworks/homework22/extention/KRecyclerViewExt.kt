package org.wikipedia.homeworks.homework22.extention

import android.content.res.Resources.NotFoundException
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework20.tools.name
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeByID(
    targetIndex: Int, //индекс блока нужного нам типа (3й топ рид например)
    targetID: Int, //
    blockName: String,
    limiter: Int, // ограничение по поиску блоков
    function: T.() -> Unit //
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.name().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findByID(
    targetIndex: Int, //индекс блока нужного нам типа (3й топ рид например)
    targetID: Int, //
    limiter: Int, // ограничение по поиску блоков
    blockName: String
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.name().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}