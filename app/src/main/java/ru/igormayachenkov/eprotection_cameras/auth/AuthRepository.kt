package ru.igormayachenkov.eprotection_cameras.auth

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.*
import ru.igormayachenkov.eprotection_cameras.App
import ru.igormayachenkov.eprotection_cameras.dataStore

class AuthRepository() {
    private val context:Context = App.instance

    private val authDataSource = AuthLocalDataSource(dataStore = context.dataStore)
    val authDataFlow = authDataSource.data

    private val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
    val exampleCounterFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[EXAMPLE_COUNTER] ?: 0
        }
    suspend fun incrementCounter() {
        context.dataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }

    private val _auth = MutableStateFlow<AuthData>(AuthData(null,null))
    val auth:StateFlow<AuthData> = _auth.asStateFlow()

    suspend fun openWorkspace(wsId:String){
        //_auth.value = _auth.value.copy( ws = Workspace(wsId, wsId.toUpperCase()) )
        authDataSource.update(AuthData(Workspace(wsId,wsId.toUpperCase()),null) )
    }
    suspend fun closeWorkspace(){
        //_auth.value = _auth.value.copy( ws = null)
        authDataSource.update(AuthData())
    }
    suspend fun login(login:String, password:String){
        //_auth.value = _auth.value.copy( user = User(13, login.toUpperCase()) )
        authDataSource.updateUser(User(13, login.toUpperCase()) )
    }
    suspend fun logout(){
        authDataSource.updateUser( null )
    }
}