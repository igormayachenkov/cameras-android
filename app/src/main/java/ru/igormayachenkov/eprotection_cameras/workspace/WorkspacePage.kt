package ru.igormayachenkov.eprotection_cameras.workspace

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.AppPage
import ru.igormayachenkov.eprotection_cameras.AppViewModel

@Composable
fun WorkspacePage() {
    val viewModel: AppViewModel = viewModel()
    Column() {
        Text(text = "Page Workspace")
        Button(onClick = { viewModel.page = AppPage.LOGIN }) {
            Text(text = "Select the workspace")
        }
    }
}