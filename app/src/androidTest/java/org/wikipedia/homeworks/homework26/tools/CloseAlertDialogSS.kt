package org.wikipedia.homeworks.homework26.tools

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView

class CloseAlertDialogSS(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override val stepInfo: String = "Закрывает диалог сихронизации статей"
    override val action: (StepInfo) -> Unit = {
        KView {
            withText("No thanks")
        }.click()
    }

    override fun isConditionMet() = waitElementById("alertTitle")
}