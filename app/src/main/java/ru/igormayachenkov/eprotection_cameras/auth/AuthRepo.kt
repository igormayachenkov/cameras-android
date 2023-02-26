package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.ui.text.toUpperCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthRepo {
    private val _auth = MutableStateFlow<AuthData>(AuthData(null,null))
    val auth:StateFlow<AuthData> = _auth.asStateFlow()

    fun openWorkspace(wsId:String){
        _auth.value = _auth.value.copy( ws = Workspace(wsId, wsId.toUpperCase()) )
    }
    fun closeWorkspace(){
        _auth.value = _auth.value.copy( ws = null)
    }
    fun login(login:String, password:String){
        _auth.value = _auth.value.copy( user = User(13, login.toUpperCase()) )
    }
    fun logout(){
        _auth.value = _auth.value.copy( user = null )
    }
}