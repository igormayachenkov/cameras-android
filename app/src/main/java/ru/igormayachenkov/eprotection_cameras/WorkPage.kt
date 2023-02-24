package ru.igormayachenkov.eprotection_cameras

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WorkPage(){
    val viewModel: AppViewModel = viewModel()
    Column() {
        Text(text = "WORK PAGE",style = MaterialTheme.typography.h3)
        Button(onClick = { viewModel.page = AppPage.LOGIN }) {
            Text(text = "Logout")
        }
    }
}