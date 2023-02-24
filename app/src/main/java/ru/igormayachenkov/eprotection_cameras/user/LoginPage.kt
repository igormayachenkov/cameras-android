package ru.igormayachenkov.eprotection_cameras.user

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.AppPage
import ru.igormayachenkov.eprotection_cameras.AppViewModel

@Composable
fun LoginPage(){
    val viewModel: AppViewModel = viewModel()
    Column() {
        Text(text = "Login Page",style = MaterialTheme.typography.h3)
        Button(onClick = { viewModel.page = AppPage.WORK }) { Text(text = "Login") }
        Button(onClick = { viewModel.page = AppPage.WORKSPACE }) { Text(text = "Exit the workspace") }
    }
}