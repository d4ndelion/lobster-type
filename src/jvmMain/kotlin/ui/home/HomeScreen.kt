package ui.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Training

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
    Column(
        Modifier.fillMaxWidth().padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        LazyRow {
            items(trainings) {
                TrainingItem(it.title)
            }
        }
    }
}

@Composable
fun TrainingItem(title: String) {
    Box(
        Modifier.size(200.dp, 70.dp).padding(horizontal = 10.dp).clip(RoundedCornerShape(4.dp))
            .background(Color.Magenta),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(title)
    }
}
