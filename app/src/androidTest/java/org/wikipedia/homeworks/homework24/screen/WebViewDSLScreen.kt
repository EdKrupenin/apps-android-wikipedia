package org.wikipedia.homeworks.homework24.screen

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework24.ReferenceListItem
import org.wikipedia.homeworks.homework24.tools.KWebViewList
import org.wikipedia.homeworks.homework24.tools.extentions.withXPath

object WebViewDSLScreen : NamedKScreen<WebViewDSLScreen>() {
    override val screenName: String = "WebViewDSL"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val referenceTitle by lazy {
        webView.withXPath("//*[@id='References']")
            .name(withParent("Заголовок 'Ссылки'"))
    }

    val reference by lazy {
        KWebViewList(webView, "//ol[@class='mw-references references']")
            .name(withParent("Список ссылок"))
    }

    fun referenceItem(index: Int = 1, function: ReferenceListItem.() -> Unit) {
        reference.childAt<ReferenceListItem>(index = index, function)
    }
}