package ru.igormayachenkov.eprotection_cameras.auth

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

private const val TAG = "myapp.AuthScreen"

@Composable
fun AuthScreen() {
    val viewModel: AuthViewModel = viewModel()
    val auth by viewModel.auth.collectAsStateWithLifecycle(AuthData(null,null))
    val counter by viewModel.counter.collectAsStateWithLifecycle(initialValue = 13)
    val authData by viewModel.authData.collectAsStateWithLifecycle(AuthData())

    Log.d(TAG,"=> authData: ${authData.toString()}")

    if(authData.ws==null)
        BeginView(
            auth=authData,
            counter=counter,
            onOpenWorkspace = viewModel::openWorkspace
        )
    else if(authData.user==null)
        LoginView(
            auth=authData,
            onLogin = viewModel::login,
            onCloseWorkspace = viewModel::closeWorkspace
        )
//    else internal error
}