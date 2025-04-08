package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepsMap = mutableMapOf<Pair<TestContext<*>, String>, Steps<*>>()

/**
 * Функция расширения getStep помогает получить или создать объект шага (Step) для данного TestContext.
 *
 * Как она работает, объяснено по шагам:
 *
 * 1. Мы создаём уникальный ключ для нашего шага. Этот ключ — пара (TestContext, typeKey):
 *    - TestContext — это «место», где выполняется тест.
 *    - typeKey — строка, которая определяет тип шага (например, "action" или "checks").
 *
 * 2. Мы пытаемся найти в глобальной карте (stepsMap) объект шага по этому ключу:
 *    - Если шаг уже существует, функция просто возвращает его.
 *    - Если шага нет, вызывается функция-creator, которая создаёт новый шаг для этого контекста.
 *      Затем новый объект сохраняется в карте по нашему ключу и возвращается.
 *
 * 3. Функция также гарантирует, что возвращаемый объект имеет правильный тип T.
 *    Если в карте объект не соответствует ожидаемому типу, функция выдаёт ошибку.
 *
 * Пример использования:
 * Допустим, у вас есть TestContext и вы хотите получить объект Action. Вы пишете:
 *     val action: Action = testContext.getStep("action", ::Action)
 * Если для данного контекста ещё не создан объект Action, он будет создан и сохранён.
 *
 * @param T Тип шага, который наследуется от Steps (например, Action или Checks).
 * @param typeKey Строка-идентификатор для шага ("action" или "checks").
 * @param creator Функция, создающая новый объект шага, если его ещё нет.
 * @return Объект типа T, соответствующий данному TestContext и typeKey.
 */
private inline fun <reified T : Steps<T>> TestContext<*>.getStep(
    typeKey: String,
    noinline creator: (TestContext<*>) -> T
): T {
    val key = Pair(this, typeKey)
    return stepsMap.getOrPut(key) { creator(this) } as? T
        ?: error("Unexpected type for key: $key")
}

val TestContext<*>.actions: Action
    get() = getStep("action", ::Action)

val TestContext<*>.checks: Checks
    get() = getStep("checks", ::Checks)

