package org.wikipedia.homeworks.homework11.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ErrorScreen : KScreen<ErrorScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val errorIcon = KImageView {
        withId(R.id.view_wiki_error_icon)
    }

    val errorText = KTextView {
        withId(R.id.view_wiki_error_text)
    }

    val errorBtn = KButton {
        withId(R.id.view_wiki_error_button)
    }
}