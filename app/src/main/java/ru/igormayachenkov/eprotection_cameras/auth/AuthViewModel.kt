package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var authData by mutableStateOf(AuthData(null,null))

    fun openWorkspace(wsId:String){
        authData = authData.copy( ws = Workspace(wsId, "Test") )
    }
    fun closeWorkspace(){
        authData = authData.copy( ws = null)
    }
    fun login(login:String, password:String){
        authData = authData.copy( user = User(13, "Igor") )
    }
    fun logout(){
        authData = authData.copy( user = null )
    }
}