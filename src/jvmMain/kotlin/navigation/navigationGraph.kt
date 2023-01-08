package navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ui.home.HomeScreen
import ui.start.StartScreen

const val HOME_SCREEN = "HOME_SCREEN"
const val START_SCREEN = "START_SCREEN"

fun RootComposeBuilder.navigationGraph() {
    screen(HOME_SCREEN) { HomeScreen() }
    screen(START_SCREEN) { StartScreen() }
}
