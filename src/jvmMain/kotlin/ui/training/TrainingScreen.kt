package ui.training

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.firstKeyboardRow
import data.numberKeyboardRow
import data.secondKeyboardRow
import data.thirdKeyboardRow
import di.appModules
import org.kodein.di.instance

private const val TEST_TEXT =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

@Preview
@Composable
fun TrainingScreen() {

    val viewModel by appModules.di.instance<TrainingVM>()
    val inputText = remember { viewModel.inputText }
    val keyboardRows = listOf(numberKeyboardRow, firstKeyboardRow, secondKeyboardRow, thirdKeyboardRow)

    Column(Modifier.fillMaxSize()) {
        Text(TEST_TEXT, Modifier.padding(start = 60.dp, end = 60.dp, top = 30.dp), fontSize = 16.sp)
        OutlinedTextField(
            inputText.value,
            onValueChange = { inputText.value = it },
            Modifier.fillMaxWidth(.75f).align(Alignment.CenterHorizontally).padding(top = 40.dp).background(Color.White)
        )
        LazyColumn(Modifier.fillMaxWidth()) {
            items(keyboardRows.size) { keyboardRowIndex ->
                LazyRow {
                    items(keyboardRows[keyboardRowIndex].size) { keyIndex ->
                        Key(keyboardRows[keyboardRowIndex][keyIndex].first)
                    }
                }
            }
        }
    }
}

@Composable
fun Key(keyChar: String) {
    Text(keyChar, Modifier.size(30.dp))
}
