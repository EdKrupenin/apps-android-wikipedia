package org.wikipedia.homeworks.homework19

import com.kaspersky.components.kautomator.component.text.UiTextViewAssertions
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.web.WebAssertions

class Checks(testContext: TestContext<*>) : Steps<Checks>(testContext) {
    fun hasText(item: UiTextViewAssertions, text: String, name: String) {
        execute(name) {
            item.hasText(text)
        }
    }

    fun hasText(item: WebAssertions, text: String, name: String) {
        execute(name) {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: UiTextViewAssertions, name: String) {
        execute(name) {
            item.hasAnyText()
        }
    }

    fun containsText(item: UiTextViewAssertions, text: String, name: String) {
        execute(name) {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String) {
        execute(name) {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String) {
        execute(name) {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        execute(name) {
            item.isDisplayed()
        }
    }

    fun isCompletelyDisplayed(item: BaseAssertions, name: String) {
        execute(name) {
            item.isCompletelyDisplayed()
        }
    }

    fun isNotOrientationNatural(device: Device) {
        execute("Check orientation isn't Natural") {
            assert(!device.uiDevice.isNaturalOrientation())
        }
    }

    fun isOrientationNatural(device: Device) {
        execute("Check orientation is Natural") {
            assert(device.uiDevice.isNaturalOrientation())
        }

    }
}