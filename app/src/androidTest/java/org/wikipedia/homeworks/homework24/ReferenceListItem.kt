package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.homeworks.homework24.tools.KWebViewElement
import org.wikipedia.homeworks.homework24.tools.KWebViewItem

class ReferenceListItem(kWebView: KWebView, xPath: String) :
    KWebViewItem<ReferenceListItem>(kWebView, xPath) {
    override val self: ReferenceListItem = this

    val index by lazy {
        child<KWebViewElement>("/div/div[@class='pcs-ref-backlink-container']")
            .name(withParent("Индекс ссылки"))
    }

    val content by lazy {
        child<KWebViewElement>("/div/div[@class='pcs-ref-body']")
            .name(withParent("Заголовок ссылки"))
    }
}