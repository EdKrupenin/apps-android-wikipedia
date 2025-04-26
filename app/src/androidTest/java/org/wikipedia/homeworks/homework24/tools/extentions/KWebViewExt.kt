package org.wikipedia.homeworks.homework24.tools.extentions

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.homeworks.homework24.tools.KWebViewElement

fun KWebView.withXPath(xPath: String) = KWebViewElement(this, xPath)