package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import org.wikipedia.homeworks.homework26.CloseCustomizeYourToolbarSS
import org.wikipedia.homeworks.homework26.ListOfSmartScenario

open class Steps<T : Steps<T>>(private val testContext: TestContext<*>) {
    private val listOfSmartScenario = ListOfSmartScenario(
        listOf(
            CloseCustomizeYourToolbarSS(testContext),
        )
    )

    @Suppress("UNCHECKED_CAST")
    operator fun invoke(block: T.() -> Unit) = block.invoke(this as T)

    protected fun execute(stepInfo: String, actions: (StepInfo) -> Unit) {
        try {
            testContext.step(stepInfo, actions)
        } catch (e: Throwable) {
            if (listOfSmartScenario.execute()) {
                testContext.step(stepInfo, actions)
            } else throw e
        }
    }
}