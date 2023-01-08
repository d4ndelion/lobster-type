import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.HOME_SCREEN
import navigation.START_SCREEN
import navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.StartScreen.Custom
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LobsterType",
        state = rememberWindowState(height = 800.dp, width = 1024.dp)
    ) {
        val isLoggedIn = remember { mutableStateOf(false) }
        val startScreen = if (isLoggedIn.value) HOME_SCREEN else START_SCREEN
        val configuration = OdysseyConfiguration(Custom(startScreen))
        setNavigationContent(configuration, onApplicationFinish = ::exitApplication) {
            navigationGraph()
        }
    }
}
