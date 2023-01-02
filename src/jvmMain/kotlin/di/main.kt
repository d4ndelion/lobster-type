package di

import org.kodein.di.DI

val appModules = DI {
    import(constantsModule)
    import(viewModelModule)
}
