package ru.igormayachenkov.eprotection_cameras

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.auth.AuthScreen
import ru.igormayachenkov.eprotection_cameras.auth.AuthViewModel

@Composable
fun AppScreen(){
    val viewModel: AuthViewModel = viewModel()
    val authData =
    if(!viewModel.authData.isAuthorized)
        AuthScreen()
    else
        WorkScreen()
}