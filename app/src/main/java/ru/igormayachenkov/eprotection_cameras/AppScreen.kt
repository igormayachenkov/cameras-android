package ru.igormayachenkov.eprotection_cameras

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.auth.AuthData
import ru.igormayachenkov.eprotection_cameras.auth.AuthScreen
import ru.igormayachenkov.eprotection_cameras.auth.AuthViewModel

@Composable
fun AppScreen(){
    val viewModel: AuthViewModel = viewModel()
    //val auth by viewModel.auth.collectAsStateWithLifecycle(AuthData(null,null))
    val authData by viewModel.authData.collectAsStateWithLifecycle(null)

    authData?.let {
        if (!it.isAuthorized)
            AuthScreen(it)
        else
            WorkScreen(it, viewModel::logout)
    }

    if(viewModel.isLoading){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0,0,0,120)
        ) {
            Text("LOADING...")
        }
    }

}