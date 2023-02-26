package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

@Composable
fun BeginView(auth:AuthData, onOpenWorkspace:(String)->Unit) {
    var wsid by rememberSaveable { mutableStateOf<String>("")

    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Page Workspace")
        TextField(value = wsid, onValueChange = {wsid=it}, placeholder = {Text("workspace id")})
        Button(
            enabled = wsid.isNotEmpty(),
            onClick = { onOpenWorkspace(wsid) }) {
            Text(text = "Open the workspace")
        }
    }
}