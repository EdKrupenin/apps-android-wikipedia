package org.wikipedia.homeworks.homework29

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.tools.NamedKScreen
import org.wikipedia.homeworks.homework20.tools.name
import org.wikipedia.views.PlainPasteEditText

object LoginScreen : NamedKScreen<LoginScreen>() {
    override val screenName: String = "LoginScreen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    private fun getTextFromRes(@StringRes resId: Int): String {
        return InstrumentationRegistry
            .getInstrumentation()
            .targetContext
            .getString(resId)
    }

    val usernameEditText = KEditText {
        isInstanceOf(PlainPasteEditText::class.java)
        withHint(this@LoginScreen.getTextFromRes(R.string.login_username_hint))
    }.name(withParent("Username EditText"))

    val passwordEditText = KEditText {
        isInstanceOf(PlainPasteEditText::class.java)
        withHint(this@LoginScreen.getTextFromRes(R.string.login_password_hint))
    }.name(withParent("Password EditText"))

    val loginButton = KButton { withId(R.id.login_button) }
        .name(withParent("Login Button"))
}