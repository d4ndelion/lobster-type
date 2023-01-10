package ui.training

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.isShiftPressed
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import di.appModules
import org.kodein.di.instance

private const val TEST_TEXT =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

@Preview
@Composable
fun TrainingScreen() {

    val viewModel by appModules.di.instance<TrainingVM>()
    val inputText = remember { viewModel.inputText }
    val keyboardRows = remember { viewModel.keyboardKeys }
    var isShiftPressed = remember { false }

    Column(Modifier.fillMaxSize().onPreviewKeyEvent {
        when {
            it.isShiftPressed -> {
                isShiftPressed = true
                viewModel.changeKeyCharRegister(true)
                return@onPreviewKeyEvent true
            }
        }
        isShiftPressed = false
        viewModel.changeKeyCharRegister(false)
        true
    }) {
        Text(TEST_TEXT, Modifier.padding(start = 60.dp, end = 60.dp, top = 30.dp), fontSize = 16.sp)
        OutlinedTextField(
            inputText.value,
            onValueChange = { inputText.value = it },
            Modifier.fillMaxWidth(.75f).align(Alignment.CenterHorizontally).padding(top = 40.dp).background(Color.White)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(top = 30.dp)
        ) {
            LazyColumn {
                items(keyboardRows.value.size) { keyboardRowIndex ->
                    LazyRow {
                        items(keyboardRows.value[keyboardRowIndex].size) { keyIndex ->
                            when {
                                keyboardRowIndex == 1 && keyIndex == 0 -> Spacer(Modifier.width(25.dp))
                                keyboardRowIndex == 2 && keyIndex == 0 -> Spacer(Modifier.width(50.dp))
                                keyboardRowIndex == 3 && keyIndex == 0 -> Spacer(Modifier.width(25.dp))
                            }
                            when (keyboardRows.value[keyboardRowIndex][keyIndex].first) {
                                "shift" -> {
                                    Key(
                                        keyboardRows.value[keyboardRowIndex][keyIndex].first,
                                        isShiftPressed
                                    )
                                    return@items
                                }
                            }
                            Key(keyboardRows.value[keyboardRowIndex][keyIndex].first)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Key(keyChar: String, isShiftPressed: Boolean = false) {
    Text(
        keyChar,
        Modifier.padding(4.dp)
            .size(50.dp)
            .clip(Shapes().medium)
            .background(if (keyChar == "shift" && isShiftPressed) Color.Red else Color.White)
            .border(1.dp, shape = Shapes().medium, color = Color.Black)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically)
    )
}
