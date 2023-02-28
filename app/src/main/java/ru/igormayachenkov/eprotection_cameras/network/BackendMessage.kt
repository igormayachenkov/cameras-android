package ru.igormayachenkov.eprotection_cameras.network

import org.json.JSONObject

class BackendMessage (
    val message:String?
) {
    constructor(json: JSONObject) : this(
        json.optString("message")
    )
}