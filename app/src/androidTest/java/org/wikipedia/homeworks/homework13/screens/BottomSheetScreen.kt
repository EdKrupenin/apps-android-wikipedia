package org.wikipedia.homeworks.homework13.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework13.items.ReferencePageItem

object BottomSheetScreen : KScreen<BottomSheetScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView { withId(R.id.reference_title_text) }

    val referencePager = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType(::ReferencePageItem)
        }
    )

    val idText = KTextView {
        withId(R.id.reference_id)
        isDisplayed()
    }
}