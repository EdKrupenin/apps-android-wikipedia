package org.wikipedia.homeworks.homework21.extentions

import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.homeworks.homework21.tools.CustomViewAssertion

fun BaseAssertions.customCheck(customViewAssertion: CustomViewAssertion){
    view.check(customViewAssertion)
}