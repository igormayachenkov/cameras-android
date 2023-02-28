package ru.igormayachenkov.eprotection_cameras.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()

    val authData = repo.authDataFlow

    fun openWorkspace(wsId:String){
        //repo.openWorkspace(wsId)
        viewModelScope.launch {
            //repo.incrementCounter()
            repo.openWorkspace(wsId)
        }
    }
    fun closeWorkspace(){
        viewModelScope.launch {
            repo.closeWorkspace()
        }
    }
    fun login(login:String, password:String){
        viewModelScope.launch {
            repo.login(login, password)
        }
    }
    fun logout(){
        viewModelScope.launch {
            repo.logout()
        }
    }
}