package org.wikipedia.homeworks.homework09.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object WebViewScreen : KScreen<WebViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KView{
        withId(R.id.page_web_view)
    }
}