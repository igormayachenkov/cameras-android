package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.user.LoginView

@Composable
fun AuthScreen() {
    val viewModel: AuthViewModel = viewModel()
    val authData = viewModel.authData
    if(authData.ws==null)
        WorkspaceView()
    else if(authData.user==null)
        LoginView()
//    else internal error
}