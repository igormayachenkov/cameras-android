package ru.igormayachenkov.eprotection_cameras

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

enum class AppPage{
    WORKSPACE,LOGIN,WORK
}

class AppViewModel : ViewModel() {
    var page by mutableStateOf(AppPage.WORKSPACE)
}