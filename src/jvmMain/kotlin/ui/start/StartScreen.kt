package ui.start

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import strings.strings

@Preview
@Composable
fun StartScreen() {

    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(strings.applicationName, Modifier.padding(bottom = 30.dp))
        TextField(
            value = login.value,
            onValueChange = { login.value = it },
            placeholder = { Text(strings.login) },
            modifier = Modifier.padding(bottom = 20.dp)
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text(strings.password) },
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Button(
            onClick = {},
            content = { Text("Enter") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 100.dp).height(50.dp)
        )
    }
}
