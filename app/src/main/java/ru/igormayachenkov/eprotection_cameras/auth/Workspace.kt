package ru.igormayachenkov.eprotection_cameras.auth

import org.json.JSONObject

data class Workspace(
    val id  : String,
    val name: String?
) {
    companion object {
        fun fromJson(json: JSONObject?) : Workspace? {
            if(json==null) return null
            return try {
                Workspace(
                    json.getString("id"),
                    json.optString("name")
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