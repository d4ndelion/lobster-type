package ui.training

import androidx.compose.runtime.mutableStateOf
import base.ViewModel
import data.capFirstKeyboardRow
import data.capSecondKeyboardRow
import data.capThirdKeyboardRow
import data.firstKeyboardRow
import data.numberKeyboardRow
import data.secondKeyboardRow
import data.thirdKeyboardRow

class TrainingVM : ViewModel {

    private val smallKeyList = listOf(numberKeyboardRow, firstKeyboardRow, secondKeyboardRow, thirdKeyboardRow)
    private val bigKeyList = listOf(numberKeyboardRow, capFirstKeyboardRow, capSecondKeyboardRow, capThirdKeyboardRow)
    val inputText = mutableStateOf("")
    val keyboardKeys = mutableStateOf(smallKeyList)

    fun changeKeyCharRegister(isCap: Boolean) {
        if (isCap) {
            keyboardKeys.value = bigKeyList
            return
        }
        keyboardKeys.value = smallKeyList
    }
}
