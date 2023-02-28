package ru.igormayachenkov.eprotection_cameras.auth

import org.json.JSONObject

data class AuthData (
    val ws : Workspace?,
    val user : User?
){
    // Empty object
    constructor():this(null,null)

    companion object{
        fun fromJson(json:JSONObject?):AuthData =
            try {
                AuthData(
                    Workspace.fromJson(json!!.optJSONObject("ws")),
                    User.fromJson(json!!.optJSONObject("user"))
                )
            }catch (_:Exception){
                AuthData()
            }
        fun fromString(string:String?):AuthData =
            try {
                val json = JSONObject(string!!)
                AuthData.fromJson(json)
            }catch (_:Exception){
                AuthData()
            }
    }
    fun toJson():JSONObject{
        val json = JSONObject()
        ws?.let   { json.put("ws", ws.toJson()) }
        user?.let { json.put("user", user.toJson()) }
        return json
    }

    override fun toString():String =
        toJson().toString()



    val isAuthorized:Boolean
        get() = ws!=null && user!=null
}