package ui.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation.Horizontal
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Training
import kotlinx.coroutines.launch
import navigation.TRAINING_SCREEN
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

val trainings = listOf(
    Training("FirstTraining", ""),
    Training("SecondTraining", ""),
    Training("ThirdTraining", ""),
    Training("FourthTraining", ""),
    Training("FifthTraining", ""),
    Training("SixthTraining", ""),
    Training("SeventhTraining", ""),
)

@Preview
@Composable
fun HomeScreen() {
    Column(
        Modifier.fillMaxSize().padding(top = 80.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home", fontSize = 30.sp)
        TrainingsRow()
    }
}

@Composable
fun TrainingsRow() {

    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier.fillMaxWidth().padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        LazyRow(
            Modifier.draggable(
                orientation = Horizontal,
                state = rememberDraggableState { delta ->
                    coroutineScope.launch {
                        scrollState.scrollBy(-delta)
                    }
                }),
            state = scrollState,
        ) {
            items(trainings) {
                TrainingItem(it.title)
            }
        }
    }
}

@Composable
fun TrainingItem(title: String) {

    val navController = LocalRootController.current

    Box(
        Modifier.size(200.dp, 70.dp).padding(horizontal = 10.dp).clip(RoundedCornerShape(4.dp))
            .background(Color.Magenta).clickable { navController.push(TRAINING_SCREEN) },
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(title)
    }
}
