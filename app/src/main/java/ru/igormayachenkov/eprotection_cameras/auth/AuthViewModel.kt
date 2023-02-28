package ru.igormayachenkov.eprotection_cameras.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    val repo = AuthRepository()

    val auth = repo.auth

    val authData = repo.authDataFlow

    val counter = repo.exampleCounterFlow

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