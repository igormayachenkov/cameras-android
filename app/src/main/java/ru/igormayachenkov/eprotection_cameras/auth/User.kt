package ru.igormayachenkov.eprotection_cameras.auth

import org.json.JSONObject

data class User(
    val id  : Long,
    val name: String
){
    companion object {
        fun fromJson(json: JSONObject?) : User? {
            if(json==null) return null
            return try {
                User(
                    json.getLong("id"),
                    json.getString("name")
                )
            } catch (_:Exception){
                null
            }
        }
    }
    fun toJson():JSONObject{
        val json = JSONObject()
        json.put("id", id)
        json.put("name",name)
        return json
    }
}
