package org.wikipedia.homeworks.homework11.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.name

object ErrorScreen : NamedKScreen<ErrorScreen>() {
    override val screenName = "Error Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val errorIcon by lazy {
        KImageView {
            withId(R.id.view_wiki_error_icon)
        }.name(withParent("error Icon"))
    }

    val errorText by lazy {
        KTextView {
            withId(R.id.view_wiki_error_text)
        }.name(withParent("error Text"))
    }

    val errorBtn by lazy {
        KButton {
            withId(R.id.view_wiki_error_button)
        }.name(withParent("error Btn"))
    }
}