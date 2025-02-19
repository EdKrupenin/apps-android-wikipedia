package org.wikipedia.homeworks.homework07.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnouncementCardViewItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementCardViewItem>(matcher) {
    val headerImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val announcementText = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val positiveButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val negativeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }
}