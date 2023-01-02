package ui.start

import androidx.compose.runtime.mutableStateOf
import base.ViewModel

class StartVM : ViewModel {
    val login = mutableStateOf("")
    val password = mutableStateOf("")
}
