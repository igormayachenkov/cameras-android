package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import ru.igormayachenkov.eprotection_cameras.auth.AuthData

@Composable
fun LoginView(auth: AuthData, onLogin:(String,String)->Unit, onCloseWorkspace:()->Unit){
    var login    by rememberSaveable { mutableStateOf<String>("") }
    var password by rememberSaveable { mutableStateOf<String>("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${auth.ws?.name}",style = MaterialTheme.typography.h4)

        TextField(value = login,    onValueChange = {login=it},    placeholder = {Text("login")})
        TextField(value = password, onValueChange = {password=it}, placeholder = {Text("password")})


        Button(onClick = { onLogin(login,password)}) { Text(text = "Login") }
        Button(onClick = onCloseWorkspace ) { Text(text = "Close the workspace") }
    }
}