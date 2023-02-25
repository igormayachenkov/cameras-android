package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WorkspaceView() {
    val viewModel: AuthViewModel = viewModel()
    Column() {
        Text(text = "Page Workspace")
        Button(onClick = { viewModel.openWorkspace("test") }) {
            Text(text = "Open the workspace")
        }
    }
}