package ru.igormayachenkov.eprotection_cameras.user

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.auth.AuthViewModel
import ru.igormayachenkov.eprotection_cameras.auth.User

@Composable
fun LoginView(){
    val viewModel: AuthViewModel = viewModel()
    Column() {
        Text(text = "Login Page",style = MaterialTheme.typography.h3)
        Button(onClick = { viewModel.login("","")}) { Text(text = "Login") }
        Button(onClick = { viewModel.closeWorkspace()}) { Text(text = "Close the workspace") }
    }
}