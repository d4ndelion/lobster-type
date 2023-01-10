package data

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase

val firstKeyboardRow = listOf(
    "Tab" to "\t"[0].code,
    "q" to "q"[0].code,
    "w" to "w"[0].code,
    "e" to "e"[0].code,
    "r" to "r"[0].code,
    "t" to "t"[0].code,
    "y" to "y"[0].code,
    "u" to "u"[0].code,
    "i" to "i"[0].code,
    "o" to "o"[0].code,
    "p" to "p"[0].code
)

val secondKeyboardRow = listOf(
    "a" to "a"[0].code,
    "s" to "s"[0].code,
    "d" to "d"[0].code,
    "f" to "f"[0].code,
    "g" to "g"[0].code,
    "h" to "h"[0].code,
    "j" to "j"[0].code,
    "k" to "k"[0].code,
    "l" to "l"[0].code,
    ";" to ";"[0].code,
    "'" to "'"[0].code
)

val thirdKeyboardRow = listOf(
    "shift" to -1,
    "z" to "z"[0].code,
    "x" to "x"[0].code,
    "c" to "c"[0].code,
    "v" to "v"[0].code,
    "b" to "b"[0].code,
    "n" to "n"[0].code,
    "m" to "m"[0].code,
    "," to ","[0].code,
    "." to "."[0].code,
    "?" to "?"[0].code
)

val numberKeyboardRow = listOf(
    "1" to "1"[0].code,
    "2" to "2"[0].code,
    "3" to "3"[0].code,
    "4" to "4"[0].code,
    "5" to "5"[0].code,
    "6" to "6"[0].code,
    "7" to "7"[0].code,
    "8" to "8"[0].code,
    "9" to "9"[0].code,
    "0" to "0"[0].code,
    "-" to "-"[0].code,
    "=" to "="[0].code
)

val capFirstKeyboardRow = firstKeyboardRow.map {
    if (it.first == "Tab") {
        return@map it.first to it.second
    }
    it.first.toUpperCase(Locale.current) to it.first.toUpperCase(Locale.current)[0].code
}

val capSecondKeyboardRow = secondKeyboardRow.map {
    it.first.toUpperCase(Locale.current) to it.first.toUpperCase(Locale.current)[0].code
}

val capThirdKeyboardRow = thirdKeyboardRow.map {
    if (it.first == "shift") {
        return@map it.first to it.second
    }
    it.first.toUpperCase(Locale.current) to it.first.toUpperCase(Locale.current)[0].code
}
