package ru.igormayachenkov.eprotection_cameras.auth

import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()

    val authData = repo.authDataFlow
    var isLoading by mutableStateOf(false)

    fun openWorkspace(wsId:String){
        viewModelScope.launch {
            isLoading = true
            repo.openWorkspace(wsId)
            isLoading = false
        }
    }
    fun closeWorkspace(){
        viewModelScope.launch {
            isLoading = true
            repo.closeWorkspace()
            isLoading = false
        }
    }
    fun login(login:String, password:String){
        viewModelScope.launch {
            isLoading = true
            repo.login(login, password)
            isLoading = false
        }
    }
    fun logout(){
        viewModelScope.launch {
            isLoading = true
            repo.logout()
            isLoading = false
        }
    }
}