package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

open class Steps<T : Steps<T>>(private val testContext: TestContext<*>) {
    @Suppress("UNCHECKED_CAST")
    operator fun invoke(block: T.() -> Unit) = block.invoke(this as T)

    protected fun execute(stepInfo: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepInfo, actions)
    }
}