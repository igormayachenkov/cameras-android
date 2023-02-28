package ru.igormayachenkov.eprotection_cameras.auth

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.igormayachenkov.eprotection_cameras.network.API

private const val TAG = "myapp.AuthRemoteDataSource"

class AuthRemoteDataSource (private val api: API) {
    suspend fun fetchWorkspaceInfo(wsId:String):Workspace{
        val ws:Workspace
        withContext(Dispatchers.IO){
            val json = api.get(
                "http://eprotection.org:8080",
                wsId,
                "/"
            )
            Log.d(TAG,json.toString())
            ws = Workspace.fromJson(json)
        }
        return ws
    }
}