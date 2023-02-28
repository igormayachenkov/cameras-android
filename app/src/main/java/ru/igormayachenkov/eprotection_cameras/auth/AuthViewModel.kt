package ru.igormayachenkov.eprotection_cameras.auth

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

private const val TAG = "myapp.AuthViewModel"

class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()

    val authData = repo.authDataFlow
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    fun openWorkspace(wsId:String){
        viewModelScope.launch {
            isLoading = true
            try {
                repo.openWorkspace(wsId)
            }catch (ex:Exception){
                Log.e(TAG,"openWorkspace ${ex.message}")
                error = ex.message
            }
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