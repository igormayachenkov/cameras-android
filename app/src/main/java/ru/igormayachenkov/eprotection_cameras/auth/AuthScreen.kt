package ru.igormayachenkov.eprotection_cameras.auth

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.AppScreen
import androidx.compose.material.Text

private const val TAG = "myapp.AuthScreen"

@Composable
fun AuthScreen(authData: AuthData) {
    val viewModel: AuthViewModel = viewModel()

    Log.d(TAG,"=> authData: ${authData.toString()}")

    if(authData.ws==null)
        BeginView(
            auth=authData,
            onOpenWorkspace = viewModel::openWorkspace
        )
    else if(authData.user==null)
        LoginView(
            auth=authData,
            onLogin = viewModel::login,
            onCloseWorkspace = viewModel::closeWorkspace
        )
//    else internal error

    // Examples
//    val auth by viewModel.auth.collectAsStateWithLifecycle(AuthData(null,null))
//    val counter by viewModel.counter.collectAsStateWithLifecycle(initialValue = 13)
}