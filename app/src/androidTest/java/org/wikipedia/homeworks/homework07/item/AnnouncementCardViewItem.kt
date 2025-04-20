package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework20.tools.withParent

class AnnouncementCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<AnnouncementCardViewItem>(matcher) {
    val headerImage by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("header Image"))
    }

    val announcementText by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("announcement Text"))
    }

    val positiveButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("positive Button"))
    }

    val negativeButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("negative Button"))
    }
}