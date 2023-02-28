package ru.igormayachenkov.eprotection_cameras.network

class APIException(
    val responseCode:Int,
    message:String?
) : Exception(message)