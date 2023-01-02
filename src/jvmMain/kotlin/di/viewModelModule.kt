package di

import org.kodein.di.DI
import org.kodein.di.bindProvider
import ui.start.StartVM

private const val VIEW_MODEL_MODULE = "VIEW_MODEL_MODULE"

val viewModelModule = DI.Module(VIEW_MODEL_MODULE) {
    bindProvider { StartVM() }
}
