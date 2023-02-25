package ru.igormayachenkov.eprotection_cameras.auth

data class AuthData (
    val ws : Workspace?,
    val user : User?
){
    val isAuthorized:Boolean
        get() = ws!=null && user!=null
}