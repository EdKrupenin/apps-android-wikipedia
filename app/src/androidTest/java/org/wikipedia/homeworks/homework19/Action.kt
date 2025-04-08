package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.web.WebActions

class Action(testContext: TestContext<*>) : Steps<Action>(testContext) {

    fun click(item: BaseActions, name: String) {
        execute("Click on '$name'") {
            item.click()
        }
    }

    fun click(item: WebActions, name: String) {
        execute("Click on '$name'") {
            item.click()
        }
    }

    fun disableNetwork(device: Device) {
        execute("Disable network") {
            device.network.disable()
        }
    }

    fun enableNetwork(device: Device) {
        execute("Enable network") {
            device.network.enable()
        }
    }

    fun typeText(
        item: EditableActions, text: String, name: String
    ) {
        execute("type text:'$text' into '$name'") {
            item.typeText(text)
        }
    }

    fun setChecked(item: CheckableActions, checked: Boolean, name: String) {
        execute("Set checked state is $checked into $name") {
            item.setChecked(checked)
        }
    }

    fun setOrientationLeft(device: Device) {
        execute("Set orientation left") {
            device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationNatural(device: Device) {
        execute("Set orientation natural") {
            device.uiDevice.setOrientationNatural()
        }
    }

    fun setOrientationRight(device: Device) {
        execute("Set orientation right") {
            device.uiDevice.setOrientationRight()
        }
    }

    fun scroll(item: WebActions, name: String) {
        execute("Scroll '$name'") {
            item.scroll()
        }
    }

    fun sleep(millis: Long) {
        execute("Take a pause $millis") {
            Thread.sleep(millis)
        }
    }
}