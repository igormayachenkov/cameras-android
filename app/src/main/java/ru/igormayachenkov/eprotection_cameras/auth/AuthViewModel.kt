package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    val repo = AuthRepo()

    val auth = repo.auth

    fun openWorkspace(wsId:String){
        repo.openWorkspace(wsId)
    }
    fun closeWorkspace(){
        repo.closeWorkspace()
    }
    fun login(login:String, password:String){
        repo.login(login,password)
    }
    fun logout(){
        repo.logout()
    }
}