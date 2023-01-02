package strings

import java.util.Locale

internal const val ENGLISH = "en"
internal const val RUSSIAN = "ru"

val strings = when(Locale.getDefault().language) {
    ENGLISH -> EngStrings
    RUSSIAN -> RuStrings
    else -> EngStrings
}

interface Strings {
    val applicationName: String
    val login: String
    val password: String
    val enter: String
}
