package org.wikipedia.homeworks.homework19

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.web.WebActions
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.screen.OnboardingScreen
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.homeworks.homework24.tools.KWebViewBaseElement
import org.wikipedia.homeworks.homework29.LoginScreen
import org.wikipedia.homeworks.homework29.Credentials

// Action должен принимать класс с шагами в классе должны быть методы которые предают только имена и
// принимают итемы,
// а наследоватся от класса класса с dsl
class Action(private val testContext: TestContext<*>) : Steps<Action>(testContext) {

    private fun getTextFromRes(@StringRes resId: Int): String {
        return InstrumentationRegistry
            .getInstrumentation()
            .targetContext
            .getString(resId)
    }

    private fun findByText(name: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .textContains(name)
            )
    }

    fun authorize(user: String) {
        execute("Пытается авторизоватся как пользователь $user") {
            val password = Credentials.getPassword(user)
            OnboardingScreen.skipBtn.click()
            val savedBnt = findByText(getTextFromRes(R.string.nav_item_more))
            savedBnt.click()
            val enterTo = findByText(getTextFromRes(R.string.main_drawer_login))
            enterTo.click()
            val loginBtn = findByText(getTextFromRes(R.string.create_account_login))
            loginBtn.click()
            LoginScreen.usernameEditText.typeText(user)
            LoginScreen.passwordEditText.typeText(password)
            LoginScreen.loginButton.click()
            testContext.device.permissions.allowViaDialog()
        }
    }

    fun click(item: BaseActions) {
        execute("Click on '${item.name()}'") {
            item.click()
        }
    }

    fun click(@StringRes resId: Int) {
        execute("Click on 'object by UI automator'") {
            findByText(getTextFromRes(resId)).click()
        }
    }

    fun click(item: UiObject) {
        execute("Click on 'UiObject'") {
            item.click()
        }
    }

    fun click(item: WebActions) {
        execute("Click on 'WebActions'") {
            item.click()
        }
    }

    fun click(item: KWebViewBaseElement<*>) {
        scroll(item)
        execute("Click on '${item.name()}'") {
            item.executeAction { click() }
        }
    }

    fun disableNetwork() {
        execute("Disable network") {
            testContext.device.network.disable()
        }
    }

    fun enableNetwork(device: Device) {
        execute("Enable network") {
            device.network.enable()
        }
    }

    fun pressBack() {
        execute("Press Back") {
            testContext.device.uiDevice.pressBack()
        }
    }

    fun swipeUp() {
        execute("Press Back") {
            testContext.device.uiDevice.swipe(
                testContext.device.uiDevice.displayWidth / 2,
                testContext.device.uiDevice.displayHeight * 3 / 4,
                testContext.device.uiDevice.displayWidth / 2,
                testContext.device.uiDevice.displayHeight / 4,
                30
            )
        }
    }

    fun typeText(
        item: EditableActions, text: String
    ) {
        execute("type text:'$text' into '$${item.name()}'") {
            item.typeText(text)
        }
    }

    fun setChecked(item: CheckableActions, checked: Boolean) {
        execute("Set checked state is $checked into ${item.name()}") {
            item.setChecked(checked)
        }
    }

    fun setOrientationLeft() {
        execute("Set orientation left") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationNatural() {
        execute("Set orientation natural") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun setOrientationRight() {
        execute("Set orientation right") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun scroll(item: WebActions) {
        execute("Scroll '${(item as BaseActions).name()}'") {
            item.scroll()
        }
    }

    fun scroll(item: KWebViewBaseElement<*>) {
        execute("Scroll '${item.name()}'") {
            testContext.flakySafely(150000) {
                item.executeAction { scroll() }
            }
        }
    }

    fun sleep(millis: Long) {
        execute("Take a pause $millis") {
            Thread.sleep(millis)
        }
    }
}