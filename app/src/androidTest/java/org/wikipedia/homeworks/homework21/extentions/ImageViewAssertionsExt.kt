package org.wikipedia.homeworks.homework21.extentions

import io.github.kakaocup.kakao.image.ImageViewAssertions
import org.wikipedia.homeworks.homework21.tools.AnyDrawable
import org.wikipedia.homeworks.homework21.tools.NoDrawable

fun ImageViewAssertions.hasAnyDrawable() {
    view.check(AnyDrawable())
}

fun ImageViewAssertions.noDrawable() {
    view.check(NoDrawable())
}