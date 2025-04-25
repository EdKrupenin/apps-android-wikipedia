package org.wikipedia.homeworks.homework24.tools

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xPath: String) = KWebViewElement(this, xPath)