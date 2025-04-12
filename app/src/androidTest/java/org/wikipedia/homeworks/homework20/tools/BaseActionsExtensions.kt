package org.wikipedia.homeworks.homework20.tools

import io.github.kakaocup.kakao.common.actions.BaseActions
import java.util.WeakHashMap

/**
Использование WeakHashMap предпочтительно для хранения ассоциированных данных (например, имени),
привязанных к объектам BaseActions, так как ключи хранятся как слабые ссылки.
Это позволяет автоматически удалять записи из карты, когда объект BaseActions больше не используется
(сборщик мусора их удалит), что предотвращает утечки памяти.
 */
private val nameWeakHashMap = WeakHashMap<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    nameWeakHashMap[this] = nameHierarchy
    return this
}

fun BaseActions.name(): NameHierarchy {
    return nameWeakHashMap[this] ?: throw RuntimeException("Set the name")
}

fun BaseActions.withParent(elementName: String) = name().withParent(elementName)