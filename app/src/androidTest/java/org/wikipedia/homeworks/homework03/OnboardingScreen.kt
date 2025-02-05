package org.wikipedia.homeworks.homework03

import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
/**
 * Дата класс для упрощения заполнения информации об элементах
 * */
data class DescriptionUIObject<T>(
    val name: String,
    val viewClass: Class<T>,
    val id: String,
    val textId: String = ""
)

/**
 * Принципы отбора значимых элементов для тестирования:
 *
 * 1. **Исключены чисто служебные контейнеры**:
 *    - LinearLayout/FrameLayout без уникальных ID (например: вложенный FrameLayout для кнопок)
 *    - Элементы, выполняющие только роль группировки других виджетов
 *    - Пример: <FrameLayout> для размещения Done/Continue кнопок
 *
 * 2. **Пропущены элементы без уникальной идентификации**:
 *    - View-разделитель (android:id отсутствует)
 *    - Элементы с чисто декоративной функцией
 *    - Пример: <View> с android:background="?attr/border_color"
 *
 * 3. **Исключено дублирование функционала**:
 *    - Вложенные контейнеры без собственной логики
 *    - Элементы, чье состояние полностью зависит от родителя
 *    - Пример: Главный FrameLayout (уже есть ViewPager2 как основной элемент)
 *
 * 4. **Оптимизация для тестирования**:
 *    - Фокус на элементах с пользовательскими взаимодействиями
 *    - Приоритет элементам с текстовым содержимым
 *    - Пример: Кнопки с текстом "Skip"/"Continue" важнее контейнеров
 *
 */

/**
 * Эти элементы присутвуют на обоих экранах
 * */
val onboardingBaseElement = listOf(
    DescriptionUIObject(
        name = "Onboarding Pager Container",
        viewClass = FrameLayout::class.java,
        id = "fragment_onboarding_pager_container"
    ),
    DescriptionUIObject(
        name = "Onboarding Pages Controller",
        viewClass = androidx.viewpager2.widget.ViewPager2::class.java,
        id = "fragment_pager"
    ),
    DescriptionUIObject(
        name = "Skip Button",
        viewClass = Button::class.java,
        id = "fragment_onboarding_skip_button",
        textId = "onboarding_skip"
    ),
    DescriptionUIObject(
        name = "Page Indicator Dots",
        viewClass = com.google.android.material.tabs.TabLayout::class.java,
        id = "view_onboarding_page_indicator"
    ),
    DescriptionUIObject(
        name = "Continue Button",
        viewClass = Button::class.java,
        id = "fragment_onboarding_forward_button",
        textId = "onboarding_continue"
    ),
    DescriptionUIObject(
        name = "Get Started Button",
        viewClass = Button::class.java,
        id = "fragment_onboarding_done_button",
        textId = "onboarding_get_started"
    )
)

val onboardingFirstScreenElements = listOf(
    DescriptionUIObject(
        name = "Onboarding Illustration Image",
        viewClass = ImageView::class.java,
        id = "imageViewCentered"
    ),
    DescriptionUIObject(
        name = "Primary Info Text",
        viewClass = org.wikipedia.views.AppTextView::class.java,
        id = "primaryTextView",
        textId = "onboarding_welcome_title_v2"
    ),
    DescriptionUIObject(
        name = "Secondary Description Text",
        viewClass = org.wikipedia.views.AppTextView::class.java,
        id = "secondaryTextView",
        textId = "onboarding_multilingual_secondary_text"
    ),
    DescriptionUIObject(
        name = "Language Selection Container",
        viewClass = LinearLayout::class.java,
        id = "languageListContainer"
    ),
    DescriptionUIObject(
        name = "Language label from language list",
        viewClass = org.wikipedia.views.AppTextView::class.java,
        id = "option_label",
        textId = "" // Похоже что заполняем в коде
    ),
    DescriptionUIObject(
        name = "Add Language Button",
        viewClass = Button::class.java,
        id = "addLanguageButton",
        textId = "onboarding_multilingual_add_language_text"
    )
)

val onboardingSecondScreenElements = listOf(
    DescriptionUIObject(
        name = "Onboarding Illustration Image",
        viewClass = ImageView::class.java,
        id = "imageViewCentered"
    ),
    DescriptionUIObject(
        name = "Primary Info Text",
        viewClass = org.wikipedia.views.AppTextView::class.java,
        id = "primaryTextView",
        textId = "onboarding_explore_title"
    ),
    DescriptionUIObject(
        name = "Secondary Description Text",
        viewClass = org.wikipedia.views.AppTextView::class.java,
        id = "secondaryTextView",
        textId = "" // Похоже что заполняем в коде
    )
)