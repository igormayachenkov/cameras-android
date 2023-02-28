package ru.igormayachenkov.eprotection_cameras.network

import org.json.JSONObject
import ru.igormayachenkov.eprotection_cameras.auth.Workspace
import java.io.File


interface API {

    // GET REQUEST
    @Throws(Exception::class)
    fun get(
        baseUrl:String,
        workspace:String,
        path:String, // load path inside a workspace: load/state, load/changes
        token:String?=null
    ): JSONObject

    // POST REQUEST
    @Throws(Exception::class)
    fun post(
        baseUrl:String,
        workspace:String,
        path:String, // load path inside a workspace: load/state, load/changes
        token:String?,
        data: JSONObject
    ): JSONObject

}