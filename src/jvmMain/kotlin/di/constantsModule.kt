package di

import java.util.Locale
import org.kodein.di.DI
import org.kodein.di.DirectDI
import org.kodein.di.bindSingleton
import strings.EngStrings
import strings.RuStrings

private const val CONSTANTS_MODULE = "CONSTANTS_MODULE"
private const val ENGLISH = "en"
private const val RUSSIAN = "ru"

private fun setStringLanguage(creator: DirectDI) = when (Locale.getDefault().language) {
    ENGLISH -> EngStrings
    RUSSIAN -> RuStrings
    else -> EngStrings
}

val constantsModule = DI.Module(CONSTANTS_MODULE) {
    bindSingleton(creator = ::setStringLanguage)
}
