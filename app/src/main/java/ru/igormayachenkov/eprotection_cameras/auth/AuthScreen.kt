package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AuthScreen() {
    val viewModel: AuthViewModel = viewModel()
    val auth by viewModel.auth.collectAsStateWithLifecycle(AuthData(null,null))
    if(auth.ws==null)
        BeginView(
            auth=auth,
            onOpenWorkspace = viewModel::openWorkspace
        )
    else if(auth.user==null)
        LoginView(
            auth=auth,
            onLogin = viewModel::login,
            onCloseWorkspace = viewModel::closeWorkspace
        )
//    else internal error
}