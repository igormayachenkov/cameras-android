package ru.igormayachenkov.eprotection_cameras

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.auth.AuthData
import ru.igormayachenkov.eprotection_cameras.auth.AuthViewModel

@Composable
fun WorkScreen(authData:AuthData, onLogout:()->Unit){

    Column() {
        Text(text = "WORK PAGE",style = MaterialTheme.typography.h3)
        Text(text = "user: ${authData.user?.name}.",style = MaterialTheme.typography.h4)
        Button(onClick = onLogout) {
            Text(text = "Logout")
        }
    }
}