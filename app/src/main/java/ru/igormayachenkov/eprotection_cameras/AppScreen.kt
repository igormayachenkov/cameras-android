package ru.igormayachenkov.eprotection_cameras

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.auth.AuthData
import ru.igormayachenkov.eprotection_cameras.auth.AuthScreen
import ru.igormayachenkov.eprotection_cameras.auth.AuthViewModel

@Composable
fun AppScreen(){
    val viewModel: AuthViewModel = viewModel()
    val auth by viewModel.auth.collectAsStateWithLifecycle(AuthData(null,null))
    if(!auth.isAuthorized)
        AuthScreen()
    else
        WorkScreen()
}