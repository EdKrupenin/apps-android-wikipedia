package org.wikipedia.homeworks.homework13.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object LinkPreviewOverlayScreen : KScreen<LinkPreviewOverlayScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val readArticle = KButton { withId(R.id.link_preview_primary_button) }
}