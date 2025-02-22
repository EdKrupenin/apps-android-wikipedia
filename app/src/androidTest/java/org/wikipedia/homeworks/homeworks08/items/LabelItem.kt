package org.wikipedia.homeworks.homeworks08.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LabelItem(matcher: Matcher<View>) : KRecyclerItem<LabelItem>(matcher) {
    val text = KTextView(matcher) {
        withId(R.id.option_label)
    }
}