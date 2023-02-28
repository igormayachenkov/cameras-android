package ru.igormayachenkov.eprotection_cameras.auth

import android.content.Context
import ru.igormayachenkov.eprotection_cameras.App
import ru.igormayachenkov.eprotection_cameras.dataStore
import ru.igormayachenkov.eprotection_cameras.network.APINative

class AuthRepository() {
    private val context:Context = App.instance

    private val localDataSource = AuthLocalDataSource(dataStore = context.dataStore)
    private val remoteDataSource= AuthRemoteDataSource(api = APINative())

    // DATA FLOW (the source of true)
    val authDataFlow = localDataSource.data

    suspend fun openWorkspace(wsId:String){
        val ws = remoteDataSource.fetchWorkspaceInfo(wsId)
        localDataSource.update(AuthData(ws,null) )
    }
    suspend fun closeWorkspace(){
        //_auth.value = _auth.value.copy( ws = null)
        localDataSource.update(AuthData())
    }
    suspend fun login(login:String, password:String){
        //_auth.value = _auth.value.copy( user = User(13, login.toUpperCase()) )
        localDataSource.updateUser(User(13, login.toUpperCase()) )
    }
    suspend fun logout(){
        localDataSource.updateUser( null )
    }

    // Counter ex
//    private val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
//    val exampleCounterFlow: Flow<Int> = context.dataStore.data
//        .map { preferences ->
//            // No type safety.
//            preferences[EXAMPLE_COUNTER] ?: 0
//        }
//    suspend fun incrementCounter() {
//        context.dataStore.edit { settings ->
//            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
//            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
//        }
//    }
    // In-memory data ex
//    private val _auth = MutableStateFlow<AuthData>(AuthData(null,null))
//    val auth:StateFlow<AuthData> = _auth.asStateFlow()

}