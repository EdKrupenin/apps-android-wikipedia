package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent

class DayHeaderCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<DayHeaderCardViewItem>(matcher) {
    val dayHeaderText by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent("day Header Text"))
    }
}