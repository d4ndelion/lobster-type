package ui.start

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import di.appModules
import org.kodein.di.instance
import strings.Strings

@Preview
@Composable
fun StartScreen() {

    val strings by appModules.di.instance<Strings>()
    val viewModel by appModules.di.instance<StartVM>()
    val login = remember { viewModel.login }
    val password = remember { viewModel.password }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(strings.applicationName, Modifier.padding(bottom = 30.dp))
        OutlinedTextField(
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(strings.login) },
            modifier = Modifier.padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(strings.password) },
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Button(
            onClick = {
                println(login.value)
                println(password.value)
            },
            content = { Text(strings.enter) },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 100.dp).height(50.dp)
        )
    }
}
