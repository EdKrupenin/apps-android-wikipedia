package org.wikipedia.homeworks.homework05

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val titleOfBottomSheetFragment = KTextView{
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val textSizePercentage = KTextView{
    withId(R.id.text_size_percent)
}

val buttonDecreaseTextSize = KTextView{
    withId(R.id.buttonDecreaseTextSize)
}

val textSizeSeekBar = KSeekBar{
    withId(R.id.text_size_seek_bar)
}

val buttonIncreaseTextSize = KTextView{
    withId(R.id.buttonIncreaseTextSize)
}

val buttonSansSerif = KButton{
    withId(R.id.button_font_family_sans_serif)
}

val buttonSerif = KButton{
    withId(R.id.button_font_family_serif)
}

val iconReadingFocusMode = KImageView{
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
    withDrawable(R.drawable.ic_icon_reading_focus_mode)
}

val readingFocusModeSwitch = KSwitch{
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val readingFocusModeDescription = KTextView{
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val titleOfTheme = KTextView {
    withText(R.string.color_theme_select)
}

object ThemeButtons {
    val light = KButton { withId(R.id.button_theme_light) }
    val sepia = KButton { withId(R.id.button_theme_sepia) }
    val dark = KButton { withId(R.id.button_theme_dark) }
    val black = KButton { withId(R.id.button_theme_black) }
}

val matchSystemThemeSwitch = KSwitch{
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val darkModeDimImagesSwitch = KSwitch{
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}