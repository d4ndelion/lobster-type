package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import ui.home.HomeScreen
import ui.start.StartScreen

@Composable
@Preview
fun App() {
    val isLoggedIn = remember { mutableStateOf(false) }
    if (isLoggedIn.value) {
        HomeScreen()
    } else StartScreen()
}
